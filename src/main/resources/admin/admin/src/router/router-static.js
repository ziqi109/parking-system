import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discusscheweixinxi from '@/views/modules/discusscheweixinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import yudingchewei from '@/views/modules/yudingchewei/list'
    import cheweixinxi from '@/views/modules/cheweixinxi/list'
    import quxiaoyuding from '@/views/modules/quxiaoyuding/list'
    import cheliangchuchang from '@/views/modules/cheliangchuchang/list'
    import cheweileixing from '@/views/modules/cheweileixing/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import tingchechang from '@/views/modules/tingchechang/list'
    import cheliangruchang from '@/views/modules/cheliangruchang/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/discusscheweixinxi',
        name: '车位信息评论',
        component: discusscheweixinxi
      }
      ,{
	path: '/storeup',
        name: '我的收藏',
        component: storeup
      }
      ,{
	path: '/yudingchewei',
        name: '预定车位',
        component: yudingchewei
      }
      ,{
	path: '/cheweixinxi',
        name: '车位信息',
        component: cheweixinxi
      }
      ,{
	path: '/quxiaoyuding',
        name: '取消预定',
        component: quxiaoyuding
      }
      ,{
	path: '/cheliangchuchang',
        name: '车辆出场',
        component: cheliangchuchang
      }
      ,{
	path: '/cheweileixing',
        name: '车位类型',
        component: cheweileixing
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/tingchechang',
        name: '停车场',
        component: tingchechang
      }
      ,{
	path: '/cheliangruchang',
        name: '车辆入场',
        component: cheliangruchang
      }
      ,{
	path: '/newstype',
        name: '通知公告分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
