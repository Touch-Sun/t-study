import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

// 引入 Bootstrap 和 Bootstrap-Vue 样式
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

// 引入全局样式
import './styles/global.css';

// 引入 Bootstrap-Vue
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';

Vue.config.productionTip = false;

// 安装 BootstrapVue
Vue.use(BootstrapVue);
// 可选的安装 BootstrapVue icon 插件
Vue.use(IconsPlugin);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
