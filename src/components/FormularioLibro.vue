<template>
  <div class="form-container">
    <h1>{{ isEdit ? 'Edit Book' : 'Add Book' }}</h1>
    <form @submit.prevent="saveBook">
      <div class="form-group">
        <label>Title:</label>
        <input v-model="book.title" required />
      </div>
      <div class="form-group">
        <label>Author:</label>
        <input v-model="book.author" required />
      </div>
      <div class="form-group">
        <label>Publication Year:</label>
        <input v-model="book.publicationYear" type="number" required />
      </div>
      <button type="submit" class="btn">Save</button>
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
        id: null,
        title: '',
        author: '',
        publicationYear: ''
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
      const url = this.isEdit ? '/books/update' : '/books/new';
      axios.post(url, this.book)
        .then(() => {
          this.$router.push('/');
        })
        .catch(error => {
          console.error(`There was an error ${this.isEdit ? 'updating' : 'adding'} the book!`, error);
        });
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
  background-color: #f9f9f9;
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