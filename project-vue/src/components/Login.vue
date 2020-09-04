<template>
<body id="poster">
  <el-form :model="loginForm" class="login-container" label-position="left" label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="username" :rules="[{ required: true, message: '请输入账号'}]">
      <el-input type="username" v-model="loginForm.username"  autocomplete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password" :rules="[{ required: true, message: '请输入密码'}]">
      <el-input type="password" v-model="loginForm.password" autocomplete="off" placeholder="密码"></el-input>
    </el-form-item>
      <el-checkbox v-model="loginForm.checked" style="float: left;">记住密码</el-checkbox>
      <el-link :underline="false" type="primary" style="float: right;" v-on:click="change">忘记密码</el-link>
      <br><br>
    <el-form-item>
      <el-button type="primary" style="width:40%;background:#505458;float: left;border:none" v-on:click="login">登录</el-button>
      <el-button type="primary" style="width:40%;background:#505458;float: right;border:none" v-on:click="sign_in">注册</el-button>
    </el-form-item>
  </el-form>
</body>
</template>

<script>

export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        checked: true
      },
      responseResult: []
    }
  },
  methods: {
    sign_in() {
      this.$router.push({path: '/change'})
    },
    login() {
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          } else {
            alert('密码或用户名错误！！！')
          }
        })
        .catch(failResponse => {
        })
    },
    change() {
      this.$router.replace({path: '/change'})
    }
  }
}
</script>

<style>
 .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
 .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  #poster {
    /* background:url("../assets/bg.jpg") no-repeat; */
    background-color: yellow;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
 body{
    margin: 0px;
  }
</style>
