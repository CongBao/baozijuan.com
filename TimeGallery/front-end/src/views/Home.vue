<template>
  <div class="home">
    <Header/>
    <Carousel/>
  </div>
</template>

<script>
// @ is an alias to /src
import Header from '@/components/common/Header.vue'
import Carousel from '@/components/home/Carousel.vue'

export default {
  name: 'home',
  components: {
    Header,
    Carousel
  }
}
</script>
