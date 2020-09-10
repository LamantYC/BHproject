<template>
<<<<<<< HEAD
  <el-container>
    <!-- <el-aside style="width: 200px;margin-top: 20px"> -->
      <switch></switch>
      <SideMenu @indexSelect='listByCategory' ref="SideMenu"></SideMenu>
    <!-- </el-aside> -->
    <el-main>
      <books class="books-area" ref="booksArea"></books>
    </el-main>
  </el-container>
=======
 <el-container>
 <el-aside style="width: 200px;margin-top: 20px">
 <switch></switch>
 <SideMenu></SideMenu>
 </el-aside>
 <el-main>
 <Books class="books-area"></Books>
 </el-main>
 </el-container>
>>>>>>> 664981a4b64553148f6a25410a355a869fe49197
</template>
<script>
import SideMenu from './SideMenu'
import Books from './Books'
export default {
  name: 'AppLibrary',
  components: {SideMenu, Books},
  methods: {
    listByCategory () {
      var _this = this
      var cid = this.$refs.SideMenu.cid
      var url = 'categories/' + cid + '/books'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.$refs.booksArea.books = resp.data
        }
      })
    }
  }
}
</script>

<style scoped>
.books-area {
width: 990px;
margin-left: auto;
margin-right: auto; }
</style>
