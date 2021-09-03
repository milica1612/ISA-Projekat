<template>
  <div>
    <h1 id="pharmacyMapCaption">My pharmacy on the map</h1>
    <v-card id="pharmacyMapCard">
    <yandex-map
      zoom="7"
      style="width: 100%; max-width: 100%; height: 98vh;"
      :coords="coords"
    >
      <ymap-marker
        v-for="(billboard, index) in surfaces"
        marker-type="placemark"
        :balloon-template="mapBalloon(billboard, index)"
        :coords="billboard.coords.split(',')"
        :marker-id="index"
        :icon="{ content: billboard.id }"
        :key="index"
      ></ymap-marker>
    </yandex-map>
    </v-card>
  </div>
</template>

<script>
/* eslint-disable */
import { yandexMap, ymapMarker } from "vue-yandex-maps";
export default {
  name: "MapExample",
  components: { yandexMap, ymapMarker },
  data() {
    return {
      coords: [44.787197, 20.457273],
      options: {
        layout: "default#image",
        imageSize: [40, 60],
        contentOffset: [0, 0]
      },
      selectedSurfaces: this.$selectedSurfaces,
      layout:
        "<div>{{ properties.balloonContentHeader }}</div><div>{{ properties.balloonContentBody }}</div><div>{{ properties.balloonContentFooter }}</div>",
      surfaces: [
        {
          id: "1",
          city: "Beograd",
          type: "Mediawall",
          address: 'ТРЦ "Океания", пр. Кутузовский, 57',
          coords: "44.787197, 20.457273"
        }
      ]
    };
  },
  mounted() {
    console.log(this.$selectedSurfaces[0]);
  },
  watch: {
    selectedSurfaces() {
      this.makeSurfaceSelected(
        this.selectedSurfaces[this.selectedSurfaces.length - 1].SURFACEID
      );
    }
  },
  methods: {
    selectedBillboard(billboard) {
      let data = {
        SURFACEID: billboard.surface_id,
        NETWORKID: billboard.networkid
      };
      return data;
    },
    makeSurfaceSelected: function(surface_id) {
      this.surfaces.forEach(surface => {
        if (surface.surface_id === surface_id) {
          surface.selected = true;
        }
      });
    },
    mapBalloon: function(billboard, index) {
      return `
      <div><h1>${billboard.id}</h1>
      <p><strong>City</strong>: ${billboard.city}</p>
      <p><strong>Type</strong>: ${billboard.type}</p>
      <p><strong>Side</strong>: ${billboard.side}</p>
      <p><strong>Address</strong>: ${billboard.address}</p>
      </div>
      `;
    }
  }
};
</script>

<style scoped>
#pharmacyMapCard {
  width: 60%;
  margin: auto;
}
#pharmacyMapCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0;
}
a {
  color: #42b983;
}
</style>
