import { createRouter, createWebHistory } from 'vue-router';
import ListaLibros from './components/ListaLibros.vue';
import FormularioLibro from './components/FormularioLibro.vue';

const routes = [
    { path: '/', name: 'bookList', component: ListaLibros },
    { path: '/books/new', name: 'newBook', component: FormularioLibro },
    { path: '/books/:title', name: 'viewBook', component: FormularioLibro, props: true },
    { path: '/books/edit/:title', name: 'editBook', component: FormularioLibro, props: true }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;