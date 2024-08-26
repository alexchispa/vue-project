<template>
    <div>
      <h1>{{ isEdit ? 'Edit Book' : 'Add Book' }}</h1>
      <form @submit.prevent="saveBook">
        <div>
          <label>Title:</label>
          <input v-model="book.title" required />
        </div>
        <div>
          <label>Author:</label>
          <input v-model="book.author" required />
        </div>
        <div>
          <label>Year:</label>
          <input v-model="book.year" type="number" required />
        </div>
        <button type="submit">Save</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    props: ['title'],
    data() {
      return {
        book: {
          title: '',
          author: '',
          year: ''
        },
        isEdit: false
      };
    },
    created() {
      if (this.title) {
        this.isEdit = true;
        axios.get(`/books/search?title=${this.title}`)
          .then(response => {
            this.book = response.data;
          })
          .catch(error => {
            console.error('There was an error fetching the book!', error);
          });
      }
    },
    methods: {
      saveBook() {
        if (this.isEdit) {
          axios.post('/books/new', this.book)
            .then(() => {
              this.$router.push('/');
            })
            .catch(error => {
              console.error('There was an error updating the book!', error);
            });
        } else {
          axios.post('/books/new', this.book)
            .then(() => {
              this.$router.push('/');
            })
            .catch(error => {
              console.error('There was an error adding the book!', error);
            });
        }
      }
    }
  };
  </script>

<style scoped>
.form-container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;

}

h1 {
  text-align: center;
  color: #333;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.btn:hover {
  background-color: #0056b3;
}
</style>