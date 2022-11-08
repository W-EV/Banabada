import { useQuery } from "react-query"
import { useParams } from "react-router-dom"
import { fetcher, QueryKeys } from "../../queryClient"
import { Product } from "../../types"

const ProductDetail = () => {
    const { id } = useParams()

    const { data } = useQuery<Product>([QueryKeys.PRODUCTS, id],
    () => 
        fetcher({
            method: 'GET',
            path: `/products/${id}`,
            //params: { id }
        }),
    )

    if (!data) return null;

    const {
        category,
        image,
        price,
        rating,
        description,
        title,
    } = data
    return (
        <div className="products-detail">
            <p className="products-detail_category">{category}</p>
            <p className="products-detail_title">{title}</p>
            <p className="products-detail_description">{description}</p>
            <img className="products-detail_image" src={image} />
            <span className="products-detail_price">${price}</span>
            <span className="products-detail_rating">{rating.rate}</span>
    </div>
    )
}

export default ProductDetail