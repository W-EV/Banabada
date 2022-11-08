import { useQuery } from "react-query"
import ProductItem from "../../components/product/item"
import {fetcher, QueryKeys } from "../../queryClient"
import { Product } from "../../types"

const ProductList = () => {
    const { data } = useQuery<Product[]>(QueryKeys.PRODUCTS, () => fetcher({
        method: 'GET',
        path: '/products'
    }),
    )

    return (
        <div>
            <ul>
                {data?.map(product=> ( //백엔드와 데이터명 맞춰서 수정할 것
                    <ProductItem {... product} key={product.id}/>
                ))}
            </ul>
        </div>
    )

}

export default ProductList