<template>
  <div>
    <el-row>
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <el-tooltip effect="dark" placement="right" v-for="item in books" :key="item.id">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <span>{{item.author}}</span> /
          <span>{{item.date}}</span> /
          <span>{{item.press}}</span>
        </p>
        <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>
        <el-card style="width: 135px;margin-bottom: 20px;height: 260px;float: left;margin-right: 15px" class="book" bodyStyle="padding:10px" shadow="hover">
          <div class="cover" @click="editBook(item)">
            <img :src="item.cover" alt="封面">
          </div>
          <div class="info">
            <div class="title">
              <a href="">{{item.title}}</a>
            </div>
          </div>
          <div class="author">{{item.author}}</div>
          <i class="el-icon-delete" @click="deleteBook(item.id)"></i>
        </el-card>
      </el-tooltip>
      <edit-form @onSubmit="handleSizeChange()" ref="edit"></edit-form>
    </el-row>
    <el-row>
      <el-pagination
        background
        layout="sizes, prev, pager, next, jumper"
        @current-change="handleCurrentChange"
        @size-change="handleSizeChange"
        :pagination="pagination"
        :page-sizes="[8, 15, 30, 50, 100]"
        :current-page="pagination.currentPage"
        :page-size="pagination.pagesize"
        :total="pagination.total">
      </el-pagination>
    </el-row>
  </div>
</template>
<script>
import EditForm from './EditForm'
import SearchBar from './SearchBar'
export default {
  name: 'Books',
  components: {EditForm, SearchBar},
  data () {
    return {
      title: '',
      cid: '',
      pagination: {
        pageIndex: 1,
        pageSize: 8,
        total: 0
      },
      books: []
    }
  },
  mounted: function () {
    this.queryList()
  },
  methods: {
    handleSizeChange (val) {
      alert(val)
      this.pagination.pagesize = val
      this.queryList()
    },
    handleCurrentChange (val) {
      this.pagination.currentPage = val
      this.queryList()
    },
    queryList () {
      let params = {
        currentPage: this.pagination.currentPage,
        pagesize: this.pagination.pagesize
      }
      var that = this
      this.$axios.get('/book', {params: params}).then((resp) => {
        console.log(resp)
        if (resp && resp.status === 200) {
          that.books = resp.data.pagination.content
          console.log(resp.data.pagination.totalPages)
          var total = resp.data.pagination.totalElements
          that.pagination.total = resp.data.pagination.content ? total : 0
          console.log(that.pagination.total)
        }
      })
    },
    searchResult () {
      var _this = this
      this.$axios
        .get('/search?keywords=' + this.$refs.searchBar.keywords, {
        }).then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
    },
    deleteBook (id) {
      this.$confirm('此操作将永久删除该数据，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancleButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios
          .post('./delete', {id: id}).then(resp => {
            if (resp && resp.status === 200) {
              this.loadBooks()
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
      alert(id)
    },
    editBook (item) {
      this.$refs.edit.dialogFormVisible = true
      this.$refs.edit.form = {
        id: item.id,
        cover: item.cover,
        title: item.title,
        author: item.author,
        date: item.date,
        press: item.press,
        abs: item.abs,
        category: {
          id: item.category.id.toString(),
          name: item.category.name
        }
      }
    }
  }
}
</script>
<style scoped>
.cover {
width: 115px;
height: 172px;
margin-bottom: 7px;
overflow: hidden;
cursor: pointer; }
img {
width: 115px;
height: 172px;
/*margin: 0 auto;*/
}
.title {
font-size: 14px;
text-align: left; }
.author {
color: #333;
width: 102px;
font-size: 13px;
margin-bottom: 6px;
text-align: left; }
.abstract {
display: block;
line-height: 17px; }a {
text-decoration: none; }
a:link, a:visited, a:focus {
color: #3377aa; }
</style>
