<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import FormularioLibro from './components/FormularioLibro.vue';
import ListaLibros from './components/ListaLibros.vue';

export default {
  name: 'App',
  components: {
    FormularioLibro,
    ListaLibros
  }
}
</script>