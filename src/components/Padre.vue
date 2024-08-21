<template>
    <div class="container">
      <FormComponent @formDataChanged="updateFormData"></FormComponent>
      <DisplayComponent :formData="formData"></DisplayComponent>
    </div>
  </template>
  
  <script>
  import FormComponent from './Form.vue';
  import DisplayComponent from './Visualizacion.vue';
  
  export default {
    components: {
      FormComponent,
      DisplayComponent
    },
    data() {
      return {
        formData: {
          Edad: '',
          LugarDeNacimiento: '',
          Situación: ''
        }
      };
    },
    methods: {
      updateFormData(newData) {
        this.formData = newData;
      }
    }
  }
  </script>

<style>
    .container {
    display: flex;
    gap: 200px;
    }
</style>