
//import React from 'react';
import { lazy } from 'react';
import GlobalLayout from './pages/_layout'

const MainPage = lazy(() => import('./pages/index'));
const ProductIndex = lazy(() => import('./pages/products/index'));
const ProductId = lazy(() => import('./pages/products/[id]'));


export const routes = [
  {
    path: '/',
    element: <GlobalLayout />,
    children: [
      { path: '/', element: <MainPage />, index: true},
      { path: '/products', element: <ProductIndex />, index: true},
      { path: '/products/:id', element: <ProductId />, },
    ]
  }
]

export const pages = [
  { route: '/' },
  { route: '/products' },
  { route: '/products/:id' }
]
