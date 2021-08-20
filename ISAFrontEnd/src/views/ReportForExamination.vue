<template>
  <div>
    <div class = "container">
      <v-simple-table>
      <template v-slot:default>
        <tr>
          <td align="center"><v-btn color="primary" elevation="2" medium>Start Examination</v-btn></td>
          <td align="center"><v-btn color="primary" elevation="2" medium>Patient did not come.</v-btn></td>
        </tr>
      </template>
      </v-simple-table>
      <br><br>
      <v-textarea
          background-color="white"
          filled
          name="input-7-4"
          label="Information about examination:"
      ></v-textarea>
      <h3>Browse new medicine for patient:</h3>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left" width="570">
              Name
            </th>
            <th class="text-left">
              Medicine specification
            </th>
            <th class="text-left">
              Availability
            </th>
          </tr>
          </thead>
          <tbody>
          <tr>
          <!--<tr
              v-for="m in medicines"
              :key="m"
          >

            <td>{{ m.name }}</td>-->
            <td>Lijek</td>
            <td><v-col cols="auto">
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="primary"
                      small
                      v-bind="attrs"
                      v-on="on"
                  >Medicine specification</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Medicine specification</v-toolbar>
                    <v-card-text>
                      <div class="text-h2 pa-12">Hello world!</div>
                    </v-card-text>
                    <v-card-actions class="justify-end">
                      <v-btn
                          text
                          @click="dialog.value = false"
                      >Close</v-btn>
                    </v-card-actions>
                  </v-card>
                </template>
              </v-dialog>
            </v-col>
            </td>
            <td><v-col cols="auto">
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="primary"
                      small
                      v-bind="attrs"
                      v-on="on"
                  >Is medicine Available?</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Is medicine available?</v-toolbar>
                    <v-card-text>
                      <div class="text-h2 pa-12">Hello world!</div>
                    </v-card-text>
                    <v-card-actions class="justify-end">
                      <h4 style="margin-top:20px;">Duration of therapy (in days):</h4>
                      <v-text-field
                          type="number"
                          filled
                          style="margin-top:10px; font-size:16px;">
                      </v-text-field>
                      <br>
                      <v-btn
                          text
                          @click="dialog.value = false"
                      >Recommend</v-btn>
                    </v-card-actions>
                  </v-card>
                </template>
              </v-dialog>
            </v-col>
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
      <br>
      <v-simple-table>
      <template v-slot:default>
        <tr>
          <td align="center"><v-btn color="primary" elevation="2" medium>End Examination</v-btn></td>
          <td align="center"><v-btn color="primary" elevation="2" medium>Schedule New Examination</v-btn></td>
        </tr>
      </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "ReportForExamination",
  data: () => ({
    medicines: []
  })
}
</script>

