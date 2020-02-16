<template>
  <div>
    <b-carousel
      id="carousel-fade"
      fade
      indicators
      img-width="1024"
      img-height="480"
      style="text-shadow: 0px 0px 2px #333;"
    >
      <b-carousel-slide
        caption="First slide"
        text="Nulla vitae elit libero, a pharetra augue mollis interdum."
        img-src="https://picsum.photos/1024/480/?image=52"
      ></b-carousel-slide>
      <b-carousel-slide
        caption="Hello"
        text="Hello World!"
        img-src="https://picsum.photos/1024/480/?image=54"
      ></b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
  export default {
    name: "Carousel"
  }
</script>