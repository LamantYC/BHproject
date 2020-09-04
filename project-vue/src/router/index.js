import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
// 导入编写的组件
import AppIndex from '@/components/AppIndex'
import Login from '@/components/Login'
import Change from '@/components/Change'
import Home from '../components/Home'
import LibraryIndex from '@/components/library/LibraryIndex'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        // {
        //   path: '/',
        //   name: 'AppIndex',
        //   redirect: '/index',
        //   component: AppIndex,
        //   meta: {
        //     requireAuth: true
        //   }
        // },
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/editform',
          name: 'EditForm',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/searchbar',
          name: 'SearchBar',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/change',
      name: 'Change',
      component: Change
    }
  ]
})
