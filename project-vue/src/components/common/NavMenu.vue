<template>
<div id="app">
    <el-menu
    :default-active="'/index'"
    router
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-menu-item index="1">首页</el-menu-item>
    <el-submenu index="2">
        <template slot="title">笔记本</template>
        <el-menu-item index="2-1">ASUS</el-menu-item>
        <el-menu-item index="2-2">MacBook</el-menu-item>
        <el-menu-item index="2-3">Redmi</el-menu-item>
    </el-submenu>
    <el-submenu index="3">
        <template slot="title">图书馆</template>
        <el-menu-item index="3-1">Java</el-menu-item>
        <el-menu-item index="3-2">MySQL</el-menu-item>
        <el-menu-item index="3-3">Python</el-menu-item>
        <el-menu-item index="4">个人中心</el-menu-item>
    </el-submenu>
    <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">
北海软件工程有限公司</span>
    </el-menu>
</div>
</template>

<script>
export default {
  name: 'NavMenu',
  data() {
    return {
      activeIndex: '1'
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
