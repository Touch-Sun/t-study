<template>
  <div class="card">
    <div class="card-header">
      <slot name="header">HelloWord</slot>
    </div>
    <div class="card-body">
      <slot>你好世界</slot>
    </div>
    <div class="card-footer">
      <slot name="footer">Footer</slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "TCard"
}
</script>

<style scoped>
.card {
  margin: 20px;
  border-radius: 20px;
}
</style>