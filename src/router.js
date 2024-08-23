import { createRouter, createWebHistory } from 'vue-router'
import Padre from '@/components/Padre.vue'
import Form from '@/components/Form.vue'
import Visualizacion from '@/components/Visualizacion.vue'

const routes = [
  {
    path: '/',
    name: 'Padre',
    component: Padre,
    children: [
      {
        path: 'details',
        name: 'Details',
        components: {
          default: Form,
          visualizacion: Visualizacion
        },
        props: {
          default: route => ({ id: route.hash.slice(1) }),
          visualizacion: route => ({ id: route.hash.slice(1) })
        }
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router