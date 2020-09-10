<template>
<body id="post">
 <div>
 <navmenu></navmenu>
 <sidebar></sidebar>
 <router-view/>
 </div>
</body>
</template>

<script>
import navmenu from './common/NavMenu'
import sidebar from './common/sidebar'
export default {
  name: 'Home',
  components: {navmenu, sidebar}
}
</script>

<style scoped>
#post{
  background-color: yellow;
  width: 100%;
  height: 2000px;
}
</style>
