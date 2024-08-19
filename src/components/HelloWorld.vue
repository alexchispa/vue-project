<template>
  <div>
    <h1>{{ message }}</h1>
    <button @click="saludar">Saludar</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: 'Hola Mundo'
    };
  },
  methods: {
    saludar() {
      alert('¡Hola desde Vue!');
    }
  }
}
</script>