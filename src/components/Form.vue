<template>
  <div>
    <div data-title>
      <h1>{{ message }}</h1>
    </div>

    <div data-form-group>
      <label for="name">Name:</label><br>
      <input type="text" id="name" v-model="localFormData.name" />
    </div>

    <div data-form-group>
      <label for="description">Description:</label><br>
      <textarea id="description" v-model="localFormData.description"></textarea>
    </div>

    <div data-form-group>
      <label for="price">Price:</label><br>
      <input type="number" id="price" v-model="localFormData.price" />
    </div>

    <div data-form-group>
      <button @click="saveFormData">Save</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    formData: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      message: 'Edit Item',
      localFormData: { ...this.formData }
    };
  },
  methods: {
    saveFormData() {
      this.$emit('saveFormData', this.localFormData);
    }
  },
  watch: {
    formData: {
      handler(newVal) {
        this.localFormData = { ...newVal };
      },
      deep: true,
      immediate: true
    }
  }
}
</script>

<style scoped>
h1 {
  color: white;
}

[data-title] {
  padding: 20px;
  padding-bottom: 10px;
  border: transparent;
  margin-bottom: 20px;
  margin: 30px;
}

[data-form-group] {
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  margin: 30px;
  width: 300px;
  margin-bottom: 15px;
}

div {
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: transparent;
}

label {
  display: block;
  margin-bottom: 5px;
  color: white;
}

input, textarea {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #333;
  color: white;
}

input[type="number"] {
  -moz-appearance: textfield;
}

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>