<template>
    <div>
      <!-- 搜索框 -->
      <div style="display:flex; margin-bottom: 20px;">
    <!-- 搜索表单 -->
    <a-form layout="inline" style="display: flex;align-items: center;">
        <a-form-item>
        <a-input v-model:value="formState.account" placeholder="账号">
        </a-input>
        </a-form-item>
        <a-form-item>
            <a-input v-model:value="formState.moudle" placeholder="模块名"> 
            </a-input>
        </a-form-item>
        <a-button type="primary"  html-type="submit" @click="handleSubmit" >搜索</a-button>

        <!-- 导出操作日志 -->
        <download-excel
          class="export-excel-wrapper"
          style="margin-left: 20px;"
          :data="data"
          :fields="json_fields"
          name="操作日志.xls">
        <a-button class="editable-btn">
          <a-icon type="cloud-download"/>
          下载操作日志 Excel
        </a-button>
      </download-excel>
    </a-form>
   
   </div>
      <!-- 表格数据 -->
      <a-table :loading="loading" :columns="columns" :data-source="data" 
      :sortDirections="['ascend', 'descend']" rowKey="id" >
        <a slot="name" slot-scope="text">{{ text }}</a>
        <span slot="customTitle"><a-icon type="smile-o"/> 账号 </span>
        <span slot="action" slot-scope="text, record, index">
            <a-divider type="vertical"/>
           <a-button @click="handleDelete(record,index)" type="link"><a-icon type="delete"/> Delete</a-button>
        </span>
      </a-table>
  
  
    </div>
  </template>
  
  <script>
  import {FindAllSystemLog,DeleteSystemLogById,querySystemLog} from "@/api/log";
  
  const columns = [
    {
      dataIndex: 'account',
      key: 'account',
      slots: {title: 'customTitle'},
      scopedSlots: {customRender: 'account'}
    },
    {
      title: '功能模块',
      dataIndex: 'module',
      key: 'module',
    },
    {
      title: '操作类型',
      dataIndex: 'busincessType',
      key: 'busincessType',
    },
    {
      title: 'IP',
      dataIndex: 'ip',
      key: 'ip',
    },
    {
      title: '操作类方法',
      key: 'method',
      dataIndex: 'method'
    },
    {
      title: '操作时间',
      key: 'time',
      dataIndex: 'time',
      defaultSortOrder: 'descend', // 默认上到下为由大到小的顺序
      sorter: (a, b) => { return a.time> b.time? 1 : -1 },
      sortField: 'time'
    },
    {
      title: '更多操作',
      key: 'action',
      scopedSlots: {customRender: 'action'},
    },
  ];
  
  // const data = [];
  
  export default {
    data() {
      return {
        formState:{
            account:"",
            moudle:""
        },
        loading: false,
        modalLoading: false,
        commodityVisible: false,
        commodityLoading: false,
        data: [],
        columns,
        hasSelected:false,
        json_fields: {
            //生成excel的字段：导出数据的字段
            '账号': 'account',
            '模块名': 'module',
            '操作类型':'busincessType',
            'Ip':'IP',
            '操作方法':'method',
            '时间':'time'
        },
      };
    },
  
    mounted() {
      this.loadTableData()
    },
  
    methods: {
      //获取表格数据
      loadTableData() {
        this.loading = true
        FindAllSystemLog().then(res=>{
          setTimeout(() => {
            this.loading = false
            this.data = res.data
          }, 600)
        })
      },
      submitCommodity() {
        this.modalLoading = true
      },
      //删除日志信息
      handleDelete(r, index) {
        DeleteSystemLogById(r.id).then((res) => {
          if (res.status) this.$message.success('日志信息删除成功');
          this.loadTableData()
        })
      },
      //条件查询处理函数
      handleSubmit(){
        querySystemLog(this.formState.account,this.formState.moudle).then(res=>{
          this.data = res.data
        })
      }
    },
  };
  </script>
  
  <style scoped>
  .editable-add-btn {
    margin-bottom: 15px;
  }
  </style>
  