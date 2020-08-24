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
  height: 1000px;
}
</style>
