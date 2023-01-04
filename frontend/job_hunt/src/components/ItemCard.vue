<template>
    <div class="card shadow-sm">
        <img class="card-img-top card-image" :src="product.image" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" @click="productDetails(product.id)">{{ product.title }}</h5>
            <h5 class="card-title">Rs. &#8377; {{ product.price * 70 }}</h5>
            <p class="card-text desc">{{ product.description }}</p>
            <p class="card-text ">{{ product.category }}</p>
            <p class="card-text"><small class="text-muted">Rating:{{ product.rating.rate }}/5</small></p>
            <div class="d-flex" style="justify-content: space-around;">
                <button class="btn btn-warning btn-text" type="button" @click="addToCart()">Add to Cart! <span
                        class="material-symbols-outlined">
                        add_shopping_cart
                    </span></button>
                <button class="btn btn-primary" type="button">Buy Now!<span class="material-symbols-outlined">
                        shopping_bag
                    </span></button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['product'],

    created() {

    },
    data() {
        return {

        }
    },
    methods: {
        productDetails(id) {
            this.$router.push(`/details/${id}`)
        },
        addToCart() {
            alert(`${this.product.title} is Added to cart!!`)
            const product = {
                id: this.product.id,
                title: this.product.title,
                img: this.product.image,
                price: this.product.price,
            };
            this.$store.commit('cart/SET_ITEM', product)
            this.$store.dispatch('cart/updateCart').then(result => console.log("dispatched methosd"))
        }
    }
}
</script>

<style>
.card-image {
    max-height: 200px;
    padding: 25px;
}

.card-text {
    font-size: 13px;
}

.card-title {
    font-size: 18px;
    font-weight: 600;
    max-block-size: 20px;
    overflow: hidden;
    text-overflow: ellipsis;
}

.card-title:hover {
    text-decoration: underline;
    cursor: pointer;
}

button {
    display: flex !important;
    justify-content: center;
}

.card:hover {
    transform: translate(0, -5px);
    border: 1px solid black
}

.card-body {
    margin-top: 0px;
}

.desc {
    max-block-size: 40px;
    overflow: hidden;
    text-overflow: ellipsis;
}

.item2 {
    flex: 0 0 33%;
}
</style>