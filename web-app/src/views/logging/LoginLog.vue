<template>
    <div>
      <!-- <div style="display: flex">
        <a-button size="large" class="editable-add-btn" @click="commodityVisible = true">
          <a-icon type="plus"/>
          新增商品
        </a-button>
        <a-input-search
            placeholder="请输入商品名"
            enter-button="搜索商品"
            style="width: 400px;margin-left: 20px"
            size="large"
            @search="onSearch"
        />
        <a-button style="margin-left: 10px" size="large" type="danger" @click="loadTableData">
          重置
        </a-button>
      </div> -->
      <a-table :loading="loading" :columns="columns" :data-source="data" :sortDirections="['ascend', 'descend']" rowKey="id" @change="tableChange" >
        <a slot="name" slot-scope="text">{{ text }}</a>
        <span slot="customTitle"><a-icon type="smile-o"/> 用户邮件</span>
        <span slot="status" slot-scope="status">
          <span v-show="status==1" style="color:#52c41a">成功</span>
          <span v-show="status==0" style="color:rgb(255, 77, 79)">失败</span>
        </span>
        <span slot="action" slot-scope="text, record, index">
        <a-divider type="vertical"/>
           <a-button @click="handleDelete(record,index)" type="link"><a-icon type="delete"/> Delete</a-button>
      </span>
      </a-table>
  
    </div>
  </template>
  
  <script>
  import {FindAllLoginLog,DeleteLoginLogById} from "@/api/log";
  
  const columns = [
    {
      dataIndex: 'email',
      key: 'name',
      slots: {title: 'customTitle'},
      scopedSlots: {customRender: 'name'}
    },
    {
      title: '浏览器类型',
      dataIndex: 'browser',
      key: 'description',
    },
    {
      title: 'IP',
      dataIndex: 'ip',
      key: 'address',
    },
    {
      title: '登录时间',
      key: 'date',
      dataIndex: 'date',
      defaultSortOrder: 'descend', // 默认上到下为由大到小的顺序
      sorter: (a, b) => { return a.date> b.date? 1 : -1 },
      sortField: 'date'
    },
    {
      title: '状态',
      key: 'status',
      dataIndex: 'status',
      scopedSlots: {customRender: 'status'},
    },
    {
      title: '更多操作',
      key: 'action',
      scopedSlots: {customRender: 'action'},
    },
  ];
  
  const data = [];
  
  export default {
    data() {
      return {
        isorter:{
          column:'date',
          order:'desc'
        },
        loading: false,
        modalLoading: false,
        commodityVisible: false,
        commodityLoading: false,
        data: [],
        columns,
      };
    },
  
    mounted() {
      this.loadTableData()
    },
  
    methods: {
      //获取表格数据
      loadTableData() {
        this.loading = true
        FindAllLoginLog().then(res=>{
          setTimeout(() => {
            this.loading = false
            this.data = res.data
          }, 600)
        })
      },
      //发生排序动作的处理函数
      tableChange(pagination, filters, sorter) {
        const { current, pageSize } = pagination;
        // this.pagination.pageSize = pageSize;
        console.log("tableChange执行了")
        if (sorter.order) {
          const { field, order } = sorter;
          this.sort = field; // 排序的数据
          this.sortType = order; // 排序方式
        } else {
          console.log("不做排序");
        }
        this.loadTableData()
      },
      submitCommodity() {
        this.modalLoading = true
      },
      //删除日志信息
      handleDelete(r, index) {
       DeleteLoginLogById(r.id).then((res) => {
          if (res.status) this.$message.success('日志信息删除成功');
          this.loadTableData()
        })
        console.log(index)
      },
  
      handleUpdate(r) {
        this.commodity = r
        this.commodityVisible = true
      },
  
    },
  };
  </script>
  
  <style scoped>
  .editable-add-btn {
    margin-bottom: 15px;
  }
  </style>
  