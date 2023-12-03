<script setup lang="ts">
import TheWelcome from '../components/TheWelcome.vue'
import AddItems from '@/components/AddItems.vue';
import ItemsView from "@/views/ItemView.vue";
</script>

<template>
  <main>
    <a href="http://localhost:5173/item"> Item Übersicht </a>
    <AddItems></AddItems>
  </main>
</template>