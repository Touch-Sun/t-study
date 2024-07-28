<template>
  <div class="home">
    <t-card />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import TCard from "@/components/TCard.vue";

export default {
  name: 'HomeView',
  components: {
    TCard,
    HelloWorld
  }
}
</script>
