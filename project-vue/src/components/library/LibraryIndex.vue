<template>
 <el-container>
 <el-aside style="width: 200px;margin-top: 20px">
 <switch></switch>
 <SideMenu></SideMenu>
 <Books class="books-area"></Books>
 </el-aside>
 <el-main>
 </el-main>
 </el-container>
</template>
<script>
import SideMenu from './SideMenu'
import Books from './Book'
export default {
  name: 'AppLibrary',
  components: {
    SideMenu,
    Books
  }
}
</script>
<style scoped>
 .books-area {
 width: 990px;
 margin-left: auto;
 margin-right: auto;
 }
</style>
