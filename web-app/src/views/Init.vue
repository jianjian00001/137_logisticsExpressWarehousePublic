<template>
  <div class="login-box">
    <div>
      <div class="box-header">
        <div class="box-header-t">账号注册</div>
      </div>
      <div class="title">物流快递仓库管理系统 - 账号注册</div>
      <a-input
        v-model="form.email"
        size="large"
        style="margin-top: 10px"
        class="input"
        placeholder="邮箱"
      >
        <a-icon slot="prefix" type="mail" />
      </a-input>
      <a-input-password
        v-model="form.password"
        size="large"
        class="input"
        placeholder="密码"
      >
        <a-icon slot="prefix" type="lock" />
      </a-input-password>

      <a-button
        :loading="submitLoading"
        class="submit-btn"
        type="primary"
        @click="submitLogin"
      >
        注册提交
      </a-button>
      <div class="des">物流快递仓库管理系统</div>
      <!-- 折叠面板 -->
      <a-collapse
        v-model:activeKey="activeKey"
        :bordered="false"
        :show-arrow="true"
      >
        <template #expandIcon="{ isActive }">
          <caret-right-outlined :rotate="isActive ? 90 : 0" />
        </template>
        <a-collapse-panel
          key="1"
          header="注册须知（点击查看）"
          :style="customStyle"
        >
          <p>邮箱长度不小于8位，密码长度不小于6位</p>
        </a-collapse-panel>
      </a-collapse>
      <router-link to="/login">返回登录页</router-link>
    </div>
  </div>
</template>

<script>
import { Init, IsInit } from '../api/admin'
// import { CaretRightOutlined } from '@ant-design/icons-vue';

export default {
  components: {
    // CaretRightOutlined
  },
  data() {
    return {
      spinning: true,
      sendLoading: false,
      submitType: '2', //1账号登录 2邮箱登录
      submitLoading: false,
      form: {
        password: '',
        email: '',
      },
      isActive: true,
      customStyle:
        'background: #f7f7f7;border-radius: 4px;margin-bottom: 24px;border: 0;overflow: hidden',
    }
  },

  mounted() {
    //检查是否有超级管理员权限（SUPER的账号
    // IsInit().then((res) => {
    //   if (res.data) this.$router.push('/login')
    // })
  },

  methods: {
    submitLogin() {
      if (this.checkEmail()) {
        Init(this.form).then((res) => {
          if (res.status) {
            this.$message.success('注册成功')
            this.$router.push('/login')
          }
        })
      }
    },

    checkEmail() {
      const emailRegex = new RegExp(
        '^\\w{3,}(\\.\\w+)*@[A-z0-9]+(\\.[A-z]{2,5}){1,2}$'
      )
      if (!emailRegex.test(this.form.email)) {
        this.$message.error('请输入正确格式的邮箱')
        return false
      } else {
        return true
      }
    },
  },
}
</script>

<style scoped>
body {
  background: #000000 !important;
}

.ant-tabs-bar {
  border-bottom: none !important;
}

.ant-btn-primary {
  border-color: #5a84fd;
}

.login-box {
  width: 350px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.box-header {
  display: flex;
}

.box-header-t {
  font-weight: bolder;
  font-size: 30px;
  letter-spacing: 1px;
}

.logo {
  width: 44px;
  height: 44px;
  margin-right: 20px;
  margin-left: 43px;
}

.ant-tabs-nav {
  width: 350px;
}

.ant-tabs-ink-bar {
  left: 52px;
}

.ant-input-affix-wrapper .ant-input {
  font-size: 12px !important;
}

.title {
  color: #91949c;
  padding-top: 15px;
  padding-bottom: 35px;
  font-size: 13px;
  text-align: center;
}

.input {
  margin-bottom: 25px;
  font-size: 10px;
}

.code-btn {
  height: 40px;
  margin-left: 30px;
}

.submit-btn {
  letter-spacing: 2px;
  background: #5a84fd;
  width: 100%;
  height: 45px;
}

.des {
  padding-top: 25px;
  font-size: 13px;
  text-align: center;
  color: #91949c;
  letter-spacing: 2px;
  margin-bottom: 20px;
}
</style>
