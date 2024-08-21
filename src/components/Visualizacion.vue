<template>
    <div>
      <h2>Datos del Formulario</h2>
      <p>Edad: {{ formData.Edad }}</p>
      <p>Lugar de nacimiento: {{ formData.LugarDeNacimiento }}</p>
      <p>Situación: {{ formData.Situación }}</p>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      formData: {
        type: Object,
        required: true
      }
    }
  }
</script>

<style scoped>
div {
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  width: 300px;
  color: white;
  margin-bottom: 500px;
}

h2 {
  margin-bottom: 15px;
  color: white;
}

p {
  margin: 5px 0;
  color: white;
}
</style>

