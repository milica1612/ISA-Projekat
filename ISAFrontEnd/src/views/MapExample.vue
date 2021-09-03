<template>
  <div class="hello">
    <yandex-map
      zoom="4"
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
  </div>
</template>

<script>
/* eslint-disable */
import { yandexMap, ymapMarker } from "vue-yandex-maps";
export default {
  name: "HelloWorld",
  components: { yandexMap, ymapMarker },
  data() {
    return {
      coords: [55.099943, 50.706567],
      options: {
        layout: "default#image",
        imageSize: [30, 40],
        contentOffset: [0, 0]
      },
      selectedSurfaces: this.$selectedSurfaces,
      layout:
        "<div>{{ properties.balloonContentHeader }}</div><div>{{ properties.balloonContentBody }}</div><div>{{ properties.balloonContentFooter }}</div>",
      surfaces: [
        {
          id: "1",
          city: "Moscow",
          type: "Mediawall",
          address: 'ТРЦ "Океания", пр. Кутузовский, 57',
          coords: "55.727790, 37.475986"
        },
        {
          id: "2",
          city: "Moscow",
          type: "Mediawall",
          address: 'ТРЦ "Хорошо!", Хорошёвское шоссе, 27',
          coords: "55.777138, 37.523430"
        },
        {
          id: "3",
          city: "Moscow",
          type: "Mediawall",
          address: "Варшавское шоссе, д. 118, корп. 1",
          coords: "55.631768, 37.618022"
        },
        {
          id: "4",
          city: "Moscow",
          type: "Mediawall",
          address: "Ленинский проспект, д. 158 ",
          coords: "55.651186, 37.483095"
        },
        {
          id: "5",
          city: "Moscow",
          type: "Mediawall",
          address: 'Волоколамское ш., 3, стр. 1, ТЦ "Карамель"',
          coords: "55.819095, 37.338341"
        },
        {
          id: "6",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: 'пл. Конституции, 3, БЦ "Leader Tower"',
          coords: "59.850483, 30.305507"
        },
        {
          id: "7",
          city: "Sochi",
          type: "Mediawall",
          address: "ул. Черноморская, 3, Жемчужина",
          coords: "43.570556, 39.732135"
        },
        {
          id: "8",
          city: "Ekaterinburg",
          type: "Mediawall",
          address: "Малышева, 36 - Деловой Центр",
          coords: "56.833531, 60.596684"
        },
        {
          id: "9",
          city: "Novosibirsk",
          type: "Mediawall",
          address: "пл.Карла Маркса.1",
          coords: "54.981371, 82.897451"
        },
        {
          id: "10",
          city: "Nizhniy Novgorod",
          type: "Mediawall",
          address: "пл. Комсомольская, 2",
          coords: "56.297103, 43.946805"
        },
        {
          id: "11",
          city: "Samara",
          type: "Mediawall",
          address: "Московское шоссе, лит.Д, 28 Б ",
          coords: "53.203573, 50.150344"
        },
        {
          id: "12",
          city: "Volgograd",
          type: "Mediawall",
          address: "Калинина, д. 13 ",
          coords: "48.699605, 44.505710"
        },
        {
          id: "13",
          city: "Chelyabinsk",
          type: "Mediawall",
          address: "Свердловский пр-т, 51",
          coords: "55.168886, 61.390149"
        },
        {
          id: "14",
          city: "Ufa",
          type: "Mediawall",
          address: "ул. Рихарда Зорге, 9",
          coords: "54.749725, 55.984356"
        },
        {
          id: "15",
          city: "Moscow",
          type: "Mediawall",
          address: "ТТК, Энтузиастов ш.,д.5 ",
          coords: "55.749519, 37.696704"
        },
        {
          id: "16",
          city: "Moscow",
          type: "Mediawall",
          address: "ТТК, Автозаводская ул.,д.18",
          side:
            "угловой фасад + 4 мф сторона Б (по ходу движения от Ленинского пр-та)",
          coords: "55.705452, 37.637749"
        },
        {
          id: "17",
          city: "Moscow",
          type: "Mediawall",
          address: "ТТК, Автозаводская ул.,д.18",
          side: "4 мф сторона А (по ходу движения к Ленинскому пр-ту)",
          coords: "55.705452, 37.637749"
        },
        {
          id: "18",
          city: "Moscow",
          type: "Mediawall",
          address: "ТТК, 5й Донской пр., д.23",
          side: "(по направлению к Ленинскому пр-ту)",
          coords: "55.701694, 37.604044"
        },
        {
          id: "19",
          city: "Moscow",
          type: "Mediawall",
          address: "МО, Химки, Ленинградское ш., д.27",
          side: "(по направлению в область)",
          coords: "55.896418, 37.431091"
        },
        {
          id: "20",
          city: "Moscow",
          type: "Mediawall",
          address: "ул. Новый Арбат, 8",
          side: "Дом Книги",
          coords: "55.753103, 37.595348"
        },
        {
          id: "21",
          city: "Moscow",
          type: "Mediawall",
          address: "ул. Новый Арбат, 24",
          side: 'Кинотеатр "ОКТЯБРЬ"',
          coords: "55.753083, 37.587614"
        },
        {
          id: "22",
          city: "Moscow",
          type: "Mediawall",
          address: "ул. Новый Арбат, 28",
          coords: "55.752886, 37.584972"
        },
        {
          id: "23",
          city: "Moscow",
          type: "Mediawall",
          address: "Ленинградское ш. Х МКАД",
          coords: "55.883455, 37.444558"
        },
        {
          id: "24",
          city: "Moscow",
          type: "Mediawall",
          address: "Можайское ш. 165 х МКАД",
          coords: "55.712247, 37.381829"
        },
        {
          id: "25",
          city: "Moscow",
          type: "Mediawall",
          address: "ул. Большая Тульская, 13",
          side: "Ереван Плаза",
          coords: "55.708729, 37.622091"
        },
        {
          id: "26",
          city: "Moscow",
          type: "Mediawall",
          address: "Останкинская башня",
          coords: "55.819721, 37.611704"
        },
        {
          id: "27",
          city: "Moscow",
          type: "Mediawall",
          address: "Проспект Мира, 150",
          side: "гостиница Космос",
          coords: "55.822265, 37.645688"
        },
        {
          id: "28",
          city: "Moscow",
          type: "DSS",
          address:
            "1-я Останкинская ул., пересечение с ул. Академика Королева (съезд с пр-та Мира) (A) из центра ",
          side: "A",
          coords: "55.82235, 37.63571"
        },
        {
          id: "29",
          city: "Moscow",
          type: "DSS",
          address: "Аминьевское ш., д.2/1 в сторону Мичуринского пр-та (B)",
          side: "B",
          coords: "55.69502, 37.46627"
        },
        {
          id: "30",
          city: "Moscow",
          type: "DSS",
          address: "Андропова пр-т, д. 19, (островок) (A) в центр",
          side: "A",
          coords: "55.68244, 37.66499"
        },
        {
          id: "31",
          city: "Moscow",
          type: "DSS",
          address: "Большая Черкизовская ул., д.32 (B) в центр  ",
          side: "B",
          coords: "55.80094, 37.74583"
        },
        {
          id: "32",
          city: "Moscow",
          type: "DSS",
          address: "Варшавское шоссе, д. 35а (B) из центра ",
          side: "B",
          coords: "55.690641, 37.622744"
        },
        {
          id: "33",
          city: "Moscow",
          type: "DSS",
          address:
            "Варшавское шоссе, н-в д.52, 500 м. после развилки с Каширским шоссе (A) в центр",
          side: "A",
          coords: "55.66678, 37.62332"
        },
        {
          id: "34",
          city: "Moscow",
          type: "DSS",
          address: "Волоколамское шоссе, пер. с Пятницким ш. (А) в центр ",
          side: "A",
          coords: "55.8336, 37.38888"
        },
        {
          id: "35",
          city: "Moscow",
          type: "DSS",
          address: "Волоколамское шоссе, пер. с ул. Панфилова (А) в центр",
          side: "A",
          coords: "55.80982, 37.48936"
        },
        {
          id: "36",
          city: "Moscow",
          type: "DSS",
          address: "Звенигородское шоссе, 3-я Магистральная ул., из центра (A)",
          side: "A",
          coords: "55.76941, 37.51465"
        },
        {
          id: "37",
          city: "Moscow",
          type: "DSS",
          address: "Каширское шоссе д.49, Сабурово (A) из центра",
          side: "A",
          coords: "55.63875, 37.68825"
        },
        {
          id: "38",
          city: "Moscow",
          type: "DSS",
          address:
            "Киевское шоссе, справа при движении из Москвы, поворот на Хованское (A)",
          side: "A",
          coords: "55.62769, 37.42428"
        },
        {
          id: "39",
          city: "Moscow",
          type: "DSS",
          address:
            "Ленинградское ш., д. 20, корпус 1., пересечение с ул. Адмирала Макарова (B) в центр",
          side: "B",
          coords: "55.82454, 37.49402"
        },
        {
          id: "40",
          city: "Moscow",
          type: "DSS",
          address:
            "Ленинградское ш., д. 73, (съезд с МКАД, у 1 оп. на въезде) (A) в центр",
          side: "A",
          coords: "55.87933, 37.44704"
        },
        {
          id: "41",
          city: "Moscow",
          type: "DSS",
          address: "Минская ул., при движении к Кутузовскому пр-ту, слева (B)",
          side: "B",
          coords: "55.72258, 37.49822"
        },
        {
          id: "42",
          city: "Moscow",
          type: "DSS",
          address:
            "Мира проспект, 81 Б стр.1 (Крестовский путепровод) (A) в центр",
          side: "A",
          coords: "55.79873, 37.63479"
        },
        {
          id: "43",
          city: "Moscow",
          type: "DSS",
          address:
            "МКАД, 1,720 км., между Энтузиастов ш. – Рязанский пр. (A) внутреннее",
          side: "A",
          coords: "55.76326, 37.842143"
        },
        {
          id: "44",
          city: "Moscow",
          type: "DSS",
          address:
            "МКАД, 23,20 км., между Волгоградский пр. – Каширское ш. (A) внутреннее",
          side: "A",
          coords: "55.599295, 37.745861"
        },
        {
          id: "45",
          city: "Moscow",
          type: "DSS",
          address:
            "МКАД, 27,85 км., между Каширское ш. – Варшавское ш. (A) внутренее",
          side: "A",
          coords: "55.573058, 37.676856"
        },
        {
          id: "46",
          city: "Moscow",
          type: "DSS",
          address:
            "МКАД, 43,45 км., между Ленинский пр. – Профсоюзная ул. (A) внешнее",
          side: "A",
          coords: "55.631629, 37.467455"
        },
        {
          id: "47",
          city: "Moscow",
          type: "DSS",
          address:
            "МКАД, 60,88 км., между Рублевское ш. – Новорижское ш. (A) внутреннее",
          side: "A",
          coords: "55.775361, 37.370283"
        },
        {
          id: "48",
          city: "Moscow",
          type: "DSS",
          address: "МКАД, 8 км, выезд с Лермонтовского пр-та (A), внешнее",
          side: "A",
          coords: "55.70988, 37.83664"
        },
        {
          id: "49",
          city: "Moscow",
          type: "DSS",
          address:
            "МКАД, 87,700 км., между Алтуфьевское ш. – Осташковское ш. (A) внутреннее",
          side: "A",
          coords: "55.898542, 37.633993"
        },
        {
          id: "50",
          city: "Moscow",
          type: "DSS",
          address: "Можайское ш., д. 33 (A) в центр",
          side: "A",
          coords: "55.71824, 37.41714"
        },
        {
          id: "51",
          city: "Moscow",
          type: "DSS",
          address:
            "Нижегородская улица, н-в д.50, пересечение с ТТК (B) в центр",
          side: "B",
          coords: "55.73596, 37.70027"
        },
        {
          id: "52",
          city: "Moscow",
          type: "DSS",
          address:
            "Рублевское шоссе, в районе дома 10 по  ул. Ивана Франко (A) в центр",
          side: "A",
          coords: "55.72709, 37.447"
        },
        {
          id: "53",
          city: "Moscow",
          type: "DSS",
          address: "Рязанский пр-т, д. 6/1 (B) в центр ",
          side: "B",
          coords: "55.72805, 37.75318"
        },
        {
          id: "54",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, Брянский пост ул (A) внутреннее",
          side: "A",
          coords: "55.77069, 37.5432"
        },
        {
          id: "55",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, Розанова ул, (A) внешнее ",
          side: "A",
          coords: "55.77314, 37.54528"
        },
        {
          id: "56",
          city: "Moscow",
          type: "DSS",
          address:
            "ТТК, Русаковская эстакада с ул. Гаврикова, д. 11 с.2 (A) внешнее",
          side: "A",
          coords: "55.77957, 37.67499"
        },
        {
          id: "57",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, СИТИ (МКЖД Тестовская) (A) внешнее ",
          side: "A",
          coords: "55.75418, 37.53117"
        },
        {
          id: "58",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, СИТИ (МКЖД Тестовская) (B) внешнее  ",
          side: "B",
          coords: "55.75418, 37.53117"
        },
        {
          id: "59",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, Сокольники, Митьковский тоннель (A) внешнее ",
          side: "A",
          coords: "55.78705, 37.6622"
        },
        {
          id: "60",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, Сокольники, Митьковский тоннель (B) внешнее ",
          side: "B",
          coords: "55.78705, 37.6622"
        },
        {
          id: "61",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, Сокольнический вал, д.37/10 (A) внутреннее",
          side: "A",
          coords: "55.79339, 37.65019"
        },
        {
          id: "62",
          city: "Moscow",
          type: "DSS",
          address: "ТТК, Сущевский вал 75 (Рижский вокзал) (А) внешнее",
          side: "A",
          coords: "55.79275, 37.62897"
        },
        {
          id: "63",
          city: "Moscow",
          type: "DSS",
          address:
            "ТТК, Съезд с Кутузовского проспекта на ТТК, 450 м.,(B) внешнее",
          side: "B",
          coords: "55.73677, 37.53807"
        },
        {
          id: "64",
          city: "Moscow",
          type: "DSS",
          address:
            "ТТК, Трофимова ул., 2-й Кожуховский пр-д, д.21 (A) внутреннее",
          side: "A",
          coords: "55.7035, 37.65732"
        },
        {
          id: "65",
          city: "Moscow",
          type: "DSS",
          address: "Шмитовский пр-д, с ул. Ермакова Роща (А) из центра",
          side: "A",
          coords: "55.7564, 37.52903"
        },
        {
          id: "66",
          city: "Moscow",
          type: "DSS",
          address: "Энтузиастов шоссе, д.28-26 (A) из центра",
          side: "A",
          coords: "55.75169, 37.71954"
        },
        {
          id: "67",
          city: "Moscow",
          type: "DSS",
          address:
            "Ярославское шоссе, н-в д.2, пр. Серебрякова пер. с Летчика Бабушкина ул. (A) в центр",
          side: "A",
          coords: "55.84809, 37.6725"
        },
        {
          id: "68",
          city: "Kazan",
          type: "Mediawall",
          address: "Пр. Ибрагимова, д. 58",
          side: "B",
          coords: "55.820104,49.0936323"
        },
        {
          id: "69",
          city: "Kazan",
          type: "Mediawall",
          address: "Проспект Победы, 159",
          side: "A",
          coords: "55.7994706,49.2095168"
        },
        {
          id: "70",
          city: "Moscow",
          type: "Mediawall",
          address: "Аэропорт Внуково, 1-я Рейсовая ул., д.1 к.2",
          side: "  ",
          coords: "55.605531, 37.289060"
        },
        {
          id: "71",
          city: "Moscow",
          type: "Mediawall",
          address: "Трасса Домодедово DME, А-105, слева при подъезде",
          side: "  ",
          coords: "55.451777, 37.859257"
        },
        {
          id: "72",
          city: "Nizhniy Novgorod",
          type: "Mediawall",
          address: "ул. Белинского, 69",
          side: "A",
          coords: "56.317577, 44.022228"
        },
        {
          id: "73",
          city: "Omsk",
          type: "Mediawall",
          address: "ул.Красный путь, д.28",
          side: "A",
          coords: "54.999810, 73.354387"
        },
        {
          id: "74",
          city: "Omsk",
          type: "Mediawall",
          address: "ул.Маршала Жукова, д.21/1",
          side: "A",
          coords: "54.985395, 73.387481"
        },
        {
          id: "75",
          city: "Samara",
          type: "Mediawall",
          address: "ул.Полевая, д.43",
          side: "A",
          coords: "53.204363, 50.124268"
        },
        {
          id: "76",
          city: "Samara",
          type: "Mediawall",
          address: "проспект Кирова, д.304",
          side: "A",
          coords: "53.249376, 50.223765"
        },
        {
          id: "77",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: "Московский пр. 105",
          side: "  ",
          coords: "59.890871, 30.318707"
        },
        {
          id: "78",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: "Каменноостровский пр. 53",
          side: "  ",
          coords: "59.970916, 30.307217"
        },
        {
          id: "79",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: "Литейный пр. 13",
          side: "  ",
          coords: "59.944792, 30.348333"
        },
        {
          id: "80",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: "Лиговский пр.149",
          side: "  ",
          coords: "59.915977, 30.350651"
        },
        {
          id: "81",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: "Каменноостровский пр.38",
          side: "  ",
          coords: "59.965903, 30.311188"
        },
        {
          id: "82",
          city: "Saint Petersburg ",
          type: "Mediawall",
          address: "Куйбышева ул., 38",
          side: "  ",
          coords: "59.957994, 30.333816"
        },
        {
          id: "83",
          city: "Chelyabinsk",
          type: "Mediawall",
          address: "ул.Труда, д.203",
          side: "A",
          coords: "55.171051, 61.355976"
        },
        {
          id: "84",
          city: "Chelyabinsk",
          type: "Mediawall",
          address: "Проспект Победы, д.168",
          side: "A",
          coords: "55.184901, 61.398493"
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
