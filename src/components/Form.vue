<template>
  <div>
    <div data-title>
      <h1 :style="{ color, transform: aGirar ? 'rotate(180deg)' : 'none' }">{{ message }}</h1>
      <button @click="delRevés">Magia</button>
    </div>

    <div data-form-group>
      <label for="Edad">Edad:</label><br>
      <select id="Edad" v-model="Edad" @change="emitFormData">
        <option value="Menor de edad">Menor de edad</option>
        <option value="Mayor de edad">Mayor de edad</option>
        <option value="Infante">Infante</option>
      </select>
    </div>

    <div data-form-group>
      <label for="Lugar de nacimiento">Lugar de nacimiento:</label><br>
      <select id="Lugar de nacimiento" v-model="LugarDeNacimiento" @change="emitFormData">
        <option value="España">España</option>
        <option value="Alemania">Alemania</option>
        <option value="Francia">Francia</option>
        <option value="Eslovenia">Eslovenia</option>
      </select>
    </div>

    <div data-form-group>
      <label for="Situación">Situación:</label><br>
      <select id="Situación" v-model="Situación" @change="emitFormData">
        <option value="Empleado">Empleado</option>
        <option value="Desempleado">Desempleado</option>
        <option value="De Baja">De Baja</option>
      </select>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: 'Formulario',
      aGirar: false,
      Edad: '',
      LugarDeNacimiento: '',
      Situación: ''
    };
  },
  methods: {
    delRevés() {
      this.aGirar = !this.aGirar;
    },
    emitFormData() {
      const formData = {
        Edad: this.Edad,
        LugarDeNacimiento: this.LugarDeNacimiento,
        Situación: this.Situación
      };
      this.$emit('formDataChanged', formData);
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
  margin: 30px ;
}

[data-form-group] {
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  margin: 30px ;
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

select {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  display: block;
  margin: 20px 0;
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
}

button:hover {
  background-color: #0056b3;
}
</style>