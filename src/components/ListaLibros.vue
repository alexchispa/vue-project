<template>
    <div>
      <h1>Book List</h1>
      <ul>
        <li id="lista" v-for="book in books" :key="book.title">
          {{ book.title }} by {{ book.author }} ({{ book.year }})
        </li>
      </ul>
      <router-link to="/books/new">Add a new book</router-link>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        books: []
      };
    },
    created() {
      axios.get('/books')
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    }
  };
  </script>

<style scoped>
.list-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
}

h1 {
    color: #4F4F4F; 
  padding-left: 16px;
  margin-top: 24px;
  text-align: center;
  font-size: 40px;
  line-height: 20px;
}

#lista {
    font-family: 'Space Mono', monospace; 
  display: flex;
  flex-direction: column;
  max-width: 420px;
  padding: 32px;
  margin: 25px auto;
  border: 1px solid #eee;
  box-shadow: 0px 12px 24px rgba(0, 0, 0, 0.06);
  color: #702020;
  border-radius: 35px;
}

</style>