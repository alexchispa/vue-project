<template>
  <div class="container">
    <TableComponent :items="items"></TableComponent>
    <router-view></router-view>
  </div>
</template>

<script>
import FormComponent from './Form.vue';
import DisplayComponent from './Visualizacion.vue';
import TableComponent from './Table.vue';

export default {
  components: {
    FormComponent,
    DisplayComponent,
    TableComponent
  },
  data() {
    return {
      items: [
        { id: 1, name: 'Item 1' },
        { id: 2, name: 'Item 2' },
        { id: 3, name: 'Item 3' }
      ],
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