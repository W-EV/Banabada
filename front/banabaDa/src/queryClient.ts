import {
    useQuery,
    useMutation,
    useQueryClient,
    QueryClient,
    QueryClientProvider,
  } from 'react-query'//@tanstack/react-query

  //import { getTodos, postTodo } from '../my-api'
  
  // Create a client

  type AnyOBJ = { [key:string]:any}

 export const getClient = (() => {
    let client: QueryClient | null = null;
    return () => {
        if(!client) client = new QueryClient({})
        return client
    }
 })()

 const BASE_URL = 'https://fakestoreapi.com'

 export const fetcher = async ({
    method,
    path,
    body, // 포스트 등...
    params
 }: {
    method: 'GET' | 'POST' | 'PUT' | 'DELETE' | 'PATCH';
    path:String;
    body?: AnyOBJ
    params ?: AnyOBJ
 }) => {

    try {
        const url = `${BASE_URL}${path}`
        const fetchOptions:RequestInit = {
            method,
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': BASE_URL
            }
        }

        

        const res = await fetch(url, fetchOptions)
        const json = await res.json()
        return json //json으로 바꾸어 리턴
    } catch (err) {
        console.error(err)
    }
 } 

 export const QueryKeys = {
    PRODUCTS: 'PRODUCTS',
 }