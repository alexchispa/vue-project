<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import Padre from './components/Padre.vue';

export default {
  name: 'App',
  components: {
    Padre
  }
}
</script>