import { createRouter, createWebHistory } from 'vue-router';
import ListaLibros from './components/ListaLibros.vue';
import FormularioLibro from './components/FormularioLibro.vue';

const routes = [
    { path: '/', component: ListaLibros },
    { path: '/books/new', component: FormularioLibro },
    { path: '/books/:title', component: FormularioLibro, props: true }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;