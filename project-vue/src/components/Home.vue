<template>
<body id="post">
 <div>
 <navmenu></navmenu>
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
  width: 100%;
  height: 2000px;
}
</style>
