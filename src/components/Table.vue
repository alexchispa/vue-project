<template>
    <div>
      <h2>Items List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in items" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.name }}</td>
            <td><button @click="showDetails(item)">Details</button></td>
          </tr>
        </tbody>
      </table>
      <Modal :visible="isModalVisible" @close="isModalVisible = false">
        <Form :formData="selectedItem" @saveFormData="saveItem" />
      </Modal>
    </div>
  </template>
  
  <script>
  import Modal from './Modal.vue';
  import Form from './Form.vue';
  
  export default {
    components: {
      Modal,
      Form
    },
    props: {
      items: {
        type: Array,
        required: true
      }
    },
    data() {
      return {
        isModalVisible: false,
        selectedItem: null
      };
    },
    methods: {
      showDetails(item) {
        this.selectedItem = { ...item };
        this.isModalVisible = true;
      },
      saveItem(updatedItem) {
        const index = this.items.findIndex(item => item.id === updatedItem.id);
        if (index !== -1) {
          this.$set(this.items, index, updatedItem);
        }
        this.isModalVisible = false;
      }
    }
  }
  </script>
  
  <style scoped>
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    border: 1px solid #ccc;
    padding: 8px;
    text-align: left;
  }
  
  th {
    background-color: #f4f4f4;
  }
  
  button {
    padding: 5px 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    text-decoration: none;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  </style>