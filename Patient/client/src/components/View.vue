<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3"> Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="15">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";
export default {
  name: "View",
  data() {
    return {
      headers: [
        {
          text: "Name",
          align: "left",
          sortable: false,
          value: "patientName"
        },
        { text: "Identification Number", value: "identityId" },
        { text: "Age", value: "age" },
        { text: "Gender", value: "gender.genderType" },
        { text: "Blood Type", value: "bloodType.name" },
        { text: "Officer", value: "createdBy.name" },
        { text: "Register Date", value: "registerDate" }
      ],
      items: []
    }; 
  },
  methods: {
    
    // ดึงข้อมูล Patient ใส่ combobox
    getPatients() {
      http
        .get("/patient")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getPatients();
    }
   
  },
  mounted() {
    this.getPatients();
  }
};
</script>