import { useQuery } from 'react-query'
import { useParams } from 'react-router-dom'
import ProductDetail from '../../components/product/detail'
import { graphqlFetcher, QueryKeys } from '../../queryClient'
import { GET_PRODUCT, Product } from '../../graphql/products'
//import { GET_PRODUCT, Product } from '../../graphql/products'

const ProductDetailPage = () => {
    const { id } = useParams()

    const { data } = useQuery<Product>([QueryKeys.PRODUCTS, id], () => 
    graphqlFetcher(GET_PRODUCT, { id }),
    )

    if (!data) return null;

    return (
        <div className="products-detail">
            <h2>상품상세</h2>
      <ProductDetail item={data} />
      </div>
    )
}

export default ProductDetailPage