<template>
<body id="post">
 <div>
 <navmenu></navmenu>
   <H1>北海软件</H1>
 <router-view/>
 </div>
</body>
</template>

<script>
import navmenu from './common/NavMenu'

export default {
  name: 'Home',
  components: {navmenu}
}
</script>

<style scoped>
#post{
  background-color: yellow;
<<<<<<< HEAD
  width: 100%;
  height: 2000px;
=======
  height: 1000px;
>>>>>>> 664981a4b64553148f6a25410a355a869fe49197
}
</style>
