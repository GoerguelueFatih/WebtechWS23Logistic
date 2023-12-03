<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';

function onSubmit() {
  console.log('submitted: ' + name.value );
  axios
      .post('http://localhost:8089/api/item', { name: name.value})
      .then((response) => {
        console.log('erstellt: ' + response.data.id);
        emit('itemAdded', response.data);
      });
}

const emit = defineEmits(['itemAdded']);

const name = ref('');
const abteilung = ref('');
const anzahl = ref('');

</script>

<template>
  <form @submit.prevent="onSubmit">
    <label>Name:</label>
    <input v-model="name" type="text">
    <label>Abteilung:</label>
    <input v-model="abteilung" type="text">
    <label>Anzahl:</label>
    <input v-model="anzahl" type="text">
    <button>Hinzufügen</button>
  </form>
  {{ name }}
  {{ abteilung }}
  {{ anzahl }}
</template>

<style scoped>

</style>
