import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import JsonExcel from 'vue-json-excel'
import 'element-ui/lib/theme-chalk/index.css'; // 导入相关样式

Vue.component('downloadExcel', JsonExcel)
Vue.config.productionTip = false

Vue.use(Antd)

new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')
