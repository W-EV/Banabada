import { useQuery } from "react-query"
import ProductItem from "../../components/product/item"
import {graphqlFetcher, QueryKeys } from "../../queryClient"
import GET_PRODUCTS, { Products } from '../../graphql/products'

const ProductList = () => {
    const { data } = useQuery<Products>(QueryKeys.PRODUCTS, () => graphqlFetcher(GET_PRODUCTS))

    return (
        <div>
            <h2>상품목록</h2>
            <ul className="products">
                {data?.products?.map(product=> ( //백엔드와 데이터명 맞춰서 수정할 것
                    <ProductItem {... product} key={product.id}/>
                ))}
            </ul>
        </div>
    )

}

export default ProductList