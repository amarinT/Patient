<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight mb-3">ระบบลงทะเบียนผู้ป่วย</h1>
      </v-flex>
    </v-layout>


    <v-row justify="center">
       <v-col cols="4">
          <v-form v-model="valid" ref="form"> 
           
          <v-row>
              <v-col cols="10">
                <v-text-field
                      outlined
                      label="Name"
                       v-model="patient.patientName"
                      :rules="[(v) => !!v || 'Item is required']"
                      required
              ></v-text-field>
              </v-col>
            </v-row>
             <v-row>
              <v-col cols="10">
                <v-text-field
                      outlined
                      label="Identification Number"
                      v-model="patient.IdentityId"
                      :rules="[(v) => !!v || 'Item is required']"
                      required
              ></v-text-field>
              </v-col>
            </v-row>
             <v-row>
              <v-col cols="10">
                <v-select
                        label="Gender"
                        outlined
                        v-model="patient.gender_id"
                        :items="genders"
                        item-text="genderType"
                        item-value="id"
                        :rules="[(v) => !!v || 'Item is required']"
                        required
                ></v-select>
              </v-col>
            </v-row>
             <v-row>
              <v-col cols="10">
                <v-text-field
                      outlined
                      label="Age"
                      v-model="patient.age"
                      :rules="[(v) => !!v || 'Item is required']"
                      required
              ></v-text-field>
              </v-col>
            </v-row>
             <v-row>
              <v-col cols="10">
                <v-select
                        label="Blood Type"
                        outlined
                        v-model="patient.bloodType_id"
                        :items="bloodTypes"
                        item-text="name"
                        item-value="id"
                        :rules="[(v) => !!v || 'Item is required']"
                        required
                ></v-select>
              </v-col>
            </v-row>
             <v-row>
              <v-col cols="10">
                <v-select
                        label="Officer" 
                        outlined
                        v-model="patient.officer_id"
                        :items="officers"
                        item-text="name"
                        item-value="id"
                        :rules="[(v) => !!v || 'Item is required']"
                        required
                ></v-select>
              </v-col>
             </v-row>
              <v-row justify="center">
              <v-col cols="12">
                <v-btn @click="savePatient" :class="{ red: !valid, green: valid }">บันทึก</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
              </v-col>
            </v-row>
            <br />
          </v-form> 
        </v-col>
      </v-row>
  </v-container>
</template>

<script>
  import http from "../http-common";
  export default {
    
    name: "patient",
    data() {
      return {
        patient: {
          patientName: "",
          IdentityId: "",
          gender_id: "",
          age: "",
          bloodType_id: "",
          officer_id: ""
         
        },
        valid: false
        
      };
    },

    methods: {

     
      // ดึงข้อมูล Officer ใส่ combobox
      getOfficers() {
        http
                .get("/officer")
                .then(response => {
                  this.officers = response.data;
                  console.log(response.data);
                })
                .catch(e => {
                  console.log(e);
                });
      },
      // ดึงข้อมูล Gender ใส่ combobox
      getGenders() {
        http
                .get("/gender")
                .then(response => {
                  this.genders = response.data;
                  console.log(response.data);
                })
                .catch(e => {
                  console.log(e);
                });
      },
      // ดึงข้อมูล BloodType ใส่ combobox
      getBloodTypes() {
        http
                .get("/bloodType")
                .then(response => {
                  this.bloodTypes = response.data;
                  console.log(response.data);
                })
                .catch(e => {
                  console.log(e);
                });
      },
      
      // function เมื่อกดปุ่ม save
      savePatient() {
        http
                .post(
                        "/patient/" +
                        this.patient.patientName +
                        "/" +
                        this.patient.IdentityId +
                        "/" +
                        this.patient.gender_id +
                        "/" +
                        this.patient.age+
                        "/" +
                        this.patient.bloodType_id +
                        "/" +
                        this.patient.officer_id
                        
                        
                )
                .then(response => {
                  console.log(response);
                  this.$router.push("/view");
                })
                .catch(e => {
                  console.log(e);
                });
        this.submitted = true;
      },
      clear() {
        this.$refs.form.reset();
        
      },
      refreshList() {
        this.getOfficers();
        this.getGenders();
        this.getBloodTypes();
      }
      /* eslint-enable no-console */
    },
    mounted() {
      this.getOfficers();
      this.getGenders();
      this.getBloodTypes();
    }
  };
</script>