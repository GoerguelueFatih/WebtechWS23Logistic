<script lang="ts">
import axios from 'axios';
import {Ref, ref } from 'vue';
import AddItems from "@/components/AddItem.vue";
import {defineComponent} from "vue";

export default defineComponent({
  components: {AddItems}
})


type Item = {
  id: string;
  name: string;
  abteilung: string;
  anzahl: number;
};
let items: Ref<Item[]> = ref([]);
axios
    .get<Item[]>('http://localhost:8089/item')
    .then((response) => {
      items.value = response.data;
    });

function onItemAdded(item: Item) {
  items.value.push(item);
}

</script>

<template>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Abteilung</th>
      <th>Anzahl</th>
    </tr>
    <tr v-for="item in items.values()" :key="item.id">
      <td>{{ item.id }}</td>
      <td>{{ item.name }}</td>
      <td>{{ item.abteilung }}</td>
      <td>{{ item.anzahl }}</td>
      <td></td>
    </tr>
  </table>

  <AddItems @itemAdded="onItemAdded"></AddItems>
</template>

<style scoped>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>