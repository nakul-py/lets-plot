/*
 * Copyright (c) 2024. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package org.jetbrains.letsPlot.core.spec.vegalite

object Penguins {
    val json = """[
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39.1,
    "Beak Depth (mm)": 18.7,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 3750,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39.5,
    "Beak Depth (mm)": 17.4,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 3800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 40.3,
    "Beak Depth (mm)": 18,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3250,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": null,
    "Beak Depth (mm)": null,
    "Flipper Length (mm)": null,
    "Body Mass (g)": null,
    "Sex": null
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 36.7,
    "Beak Depth (mm)": 19.3,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39.3,
    "Beak Depth (mm)": 20.6,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3650,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 38.9,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 3625,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39.2,
    "Beak Depth (mm)": 19.6,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4675,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 34.1,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3475,
    "Sex": null
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 42,
    "Beak Depth (mm)": 20.2,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 4250,
    "Sex": null
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 37.8,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 3300,
    "Sex": null
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 37.8,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 180,
    "Body Mass (g)": 3700,
    "Sex": null
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 17.6,
    "Flipper Length (mm)": 182,
    "Body Mass (g)": 3200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 38.6,
    "Beak Depth (mm)": 21.2,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 34.6,
    "Beak Depth (mm)": 21.1,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 4400,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 36.6,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 38.7,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 42.5,
    "Beak Depth (mm)": 20.7,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 4500,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 34.4,
    "Beak Depth (mm)": 18.4,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 3325,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 46,
    "Beak Depth (mm)": 21.5,
    "Flipper Length (mm)": 194,
    "Body Mass (g)": 4200,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.8,
    "Beak Depth (mm)": 18.3,
    "Flipper Length (mm)": 174,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.7,
    "Beak Depth (mm)": 18.7,
    "Flipper Length (mm)": 180,
    "Body Mass (g)": 3600,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 35.9,
    "Beak Depth (mm)": 19.2,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 38.2,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 38.8,
    "Beak Depth (mm)": 17.2,
    "Flipper Length (mm)": 180,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 35.3,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 40.6,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 183,
    "Body Mass (g)": 3550,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 40.5,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.9,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 172,
    "Body Mass (g)": 3150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 40.5,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 180,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.5,
    "Beak Depth (mm)": 16.7,
    "Flipper Length (mm)": 178,
    "Body Mass (g)": 3250,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.2,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 178,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.5,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 188,
    "Body Mass (g)": 3300,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.9,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.4,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3325,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.2,
    "Beak Depth (mm)": 21.1,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 4150,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 38.8,
    "Beak Depth (mm)": 20,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 42.2,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 180,
    "Body Mass (g)": 3550,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.6,
    "Beak Depth (mm)": 19.3,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 3300,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.8,
    "Beak Depth (mm)": 19.1,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 4650,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.5,
    "Beak Depth (mm)": 18,
    "Flipper Length (mm)": 182,
    "Body Mass (g)": 3150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.8,
    "Beak Depth (mm)": 18.4,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 3100,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 44.1,
    "Beak Depth (mm)": 19.7,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 4400,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37,
    "Beak Depth (mm)": 16.9,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3000,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.6,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 4600,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 182,
    "Body Mass (g)": 3425,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.5,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 179,
    "Body Mass (g)": 2975,
    "Sex": null
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 42.3,
    "Beak Depth (mm)": 21.2,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 4150,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 39.6,
    "Beak Depth (mm)": 17.7,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 3500,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 40.1,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 188,
    "Body Mass (g)": 4300,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 35,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 42,
    "Beak Depth (mm)": 19.5,
    "Flipper Length (mm)": 200,
    "Body Mass (g)": 4050,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 34.5,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 2900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 41.4,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3700,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 39,
    "Beak Depth (mm)": 17.5,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 3550,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 40.6,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 36.5,
    "Beak Depth (mm)": 16.6,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 2850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.6,
    "Beak Depth (mm)": 19.1,
    "Flipper Length (mm)": 194,
    "Body Mass (g)": 3750,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 35.7,
    "Beak Depth (mm)": 16.9,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 41.3,
    "Beak Depth (mm)": 21.1,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4400,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.6,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 18.2,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 4050,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 36.4,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 2850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 41.6,
    "Beak Depth (mm)": 18,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 35.5,
    "Beak Depth (mm)": 16.2,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3350,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 19.1,
    "Flipper Length (mm)": 188,
    "Body Mass (g)": 4100,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 35.9,
    "Beak Depth (mm)": 16.6,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3050,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 41.8,
    "Beak Depth (mm)": 19.4,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 4450,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 33.5,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39.7,
    "Beak Depth (mm)": 18.4,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39.6,
    "Beak Depth (mm)": 17.2,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 3550,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 45.8,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 4150,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 35.5,
    "Beak Depth (mm)": 17.5,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 42.8,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4250,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 40.9,
    "Beak Depth (mm)": 16.8,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 37.2,
    "Beak Depth (mm)": 19.4,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 36.2,
    "Beak Depth (mm)": 16.1,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3550,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 42.1,
    "Beak Depth (mm)": 19.1,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4000,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 34.6,
    "Beak Depth (mm)": 17.2,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 42.9,
    "Beak Depth (mm)": 17.6,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 4700,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 36.7,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 35.1,
    "Beak Depth (mm)": 19.4,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 4200,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.3,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3350,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 41.3,
    "Beak Depth (mm)": 20.3,
    "Flipper Length (mm)": 194,
    "Body Mass (g)": 3550,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.3,
    "Beak Depth (mm)": 19.5,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.9,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3500,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 38.3,
    "Beak Depth (mm)": 19.2,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 38.9,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 35.7,
    "Beak Depth (mm)": 18,
    "Flipper Length (mm)": 202,
    "Body Mass (g)": 3550,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 205,
    "Body Mass (g)": 4300,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 34,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.6,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 4450,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.2,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3300,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.8,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 4300,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 38.1,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.3,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 4350,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 33.1,
    "Beak Depth (mm)": 16.1,
    "Flipper Length (mm)": 178,
    "Body Mass (g)": 2900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 43.2,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 4100,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 35,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 3725,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 41,
    "Beak Depth (mm)": 20,
    "Flipper Length (mm)": 203,
    "Body Mass (g)": 4725,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.7,
    "Beak Depth (mm)": 16,
    "Flipper Length (mm)": 183,
    "Body Mass (g)": 3075,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.8,
    "Beak Depth (mm)": 20,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 4250,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 37.9,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 2925,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 39.7,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 3550,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 38.6,
    "Beak Depth (mm)": 17.2,
    "Flipper Length (mm)": 199,
    "Body Mass (g)": 3750,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 38.2,
    "Beak Depth (mm)": 20,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 38.1,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 3175,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.2,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 4775,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 38.1,
    "Beak Depth (mm)": 16.5,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 3825,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.6,
    "Beak Depth (mm)": 20.3,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 4600,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 39.7,
    "Beak Depth (mm)": 17.7,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 42.2,
    "Beak Depth (mm)": 19.5,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 4275,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 39.6,
    "Beak Depth (mm)": 20.7,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Biscoe",
    "Beak Length (mm)": 42.7,
    "Beak Depth (mm)": 18.3,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 4075,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 38.6,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 188,
    "Body Mass (g)": 2900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 37.3,
    "Beak Depth (mm)": 20.5,
    "Flipper Length (mm)": 199,
    "Body Mass (g)": 3775,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 35.7,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3350,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3325,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 36.2,
    "Beak Depth (mm)": 17.2,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 37.7,
    "Beak Depth (mm)": 19.8,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 3500,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 40.2,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 176,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 41.4,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 202,
    "Body Mass (g)": 3875,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 35.2,
    "Beak Depth (mm)": 15.9,
    "Flipper Length (mm)": 186,
    "Body Mass (g)": 3050,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 40.6,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 199,
    "Body Mass (g)": 4000,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 38.8,
    "Beak Depth (mm)": 17.6,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3275,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 41.5,
    "Beak Depth (mm)": 18.3,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4300,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 39,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3050,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 44.1,
    "Beak Depth (mm)": 18,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4000,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 38.5,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3325,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Torgersen",
    "Beak Length (mm)": 43.1,
    "Beak Depth (mm)": 19.2,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 3500,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.8,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3500,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.5,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 199,
    "Body Mass (g)": 4475,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 38.1,
    "Beak Depth (mm)": 17.6,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3425,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 41.1,
    "Beak Depth (mm)": 17.5,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 35.6,
    "Beak Depth (mm)": 17.5,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3175,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.2,
    "Beak Depth (mm)": 20.1,
    "Flipper Length (mm)": 200,
    "Body Mass (g)": 3975,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37,
    "Beak Depth (mm)": 16.5,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.7,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 4250,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.2,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.6,
    "Beak Depth (mm)": 17.2,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3475,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 32.1,
    "Beak Depth (mm)": 15.5,
    "Flipper Length (mm)": 188,
    "Body Mass (g)": 3050,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 40.7,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3725,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.3,
    "Beak Depth (mm)": 16.8,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 3000,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39,
    "Beak Depth (mm)": 18.7,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3650,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 39.2,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 4250,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36.6,
    "Beak Depth (mm)": 18.4,
    "Flipper Length (mm)": 184,
    "Body Mass (g)": 3475,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 37.8,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3750,
    "Sex": "MALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 36,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Adelie",
    "Island": "Dream",
    "Beak Length (mm)": 41.5,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 201,
    "Body Mass (g)": 4000,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.5,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 3500,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50,
    "Beak Depth (mm)": 19.5,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 3900,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.3,
    "Beak Depth (mm)": 19.2,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3650,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.4,
    "Beak Depth (mm)": 18.7,
    "Flipper Length (mm)": 188,
    "Body Mass (g)": 3525,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 52.7,
    "Beak Depth (mm)": 19.8,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 3725,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.2,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 3950,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.1,
    "Beak Depth (mm)": 18.2,
    "Flipper Length (mm)": 178,
    "Body Mass (g)": 3250,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.3,
    "Beak Depth (mm)": 18.2,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 3750,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46,
    "Beak Depth (mm)": 18.9,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.3,
    "Beak Depth (mm)": 19.9,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 3700,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.6,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.7,
    "Beak Depth (mm)": 20.3,
    "Flipper Length (mm)": 194,
    "Body Mass (g)": 3775,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 47,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 185,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 52,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 201,
    "Body Mass (g)": 4050,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.9,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3575,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.5,
    "Beak Depth (mm)": 19.6,
    "Flipper Length (mm)": 201,
    "Body Mass (g)": 4050,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.3,
    "Beak Depth (mm)": 20,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 3300,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 58,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.4,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49.2,
    "Beak Depth (mm)": 18.2,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 4400,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 42.4,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 181,
    "Body Mass (g)": 3600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 48.5,
    "Beak Depth (mm)": 17.5,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3400,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 43.2,
    "Beak Depth (mm)": 16.6,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 2900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.6,
    "Beak Depth (mm)": 19.4,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.7,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3300,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 52,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 4150,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.5,
    "Beak Depth (mm)": 18.4,
    "Flipper Length (mm)": 200,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49.5,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 200,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.4,
    "Beak Depth (mm)": 17.8,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 52.8,
    "Beak Depth (mm)": 20,
    "Flipper Length (mm)": 205,
    "Body Mass (g)": 4550,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 40.9,
    "Beak Depth (mm)": 16.6,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 54.2,
    "Beak Depth (mm)": 20.8,
    "Flipper Length (mm)": 201,
    "Body Mass (g)": 4300,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 42.5,
    "Beak Depth (mm)": 16.7,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3350,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 203,
    "Body Mass (g)": 4100,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49.7,
    "Beak Depth (mm)": 18.6,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3600,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 47.5,
    "Beak Depth (mm)": 16.8,
    "Flipper Length (mm)": 199,
    "Body Mass (g)": 3900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 47.6,
    "Beak Depth (mm)": 18.3,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 52,
    "Beak Depth (mm)": 20.7,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4800,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.9,
    "Beak Depth (mm)": 16.6,
    "Flipper Length (mm)": 192,
    "Body Mass (g)": 2700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 53.5,
    "Beak Depth (mm)": 19.9,
    "Flipper Length (mm)": 205,
    "Body Mass (g)": 4500,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49,
    "Beak Depth (mm)": 19.5,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.2,
    "Beak Depth (mm)": 17.5,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3650,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.9,
    "Beak Depth (mm)": 19.1,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 3550,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.5,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 3500,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.9,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 196,
    "Body Mass (g)": 3675,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.8,
    "Beak Depth (mm)": 18.5,
    "Flipper Length (mm)": 201,
    "Body Mass (g)": 4450,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.1,
    "Beak Depth (mm)": 17.9,
    "Flipper Length (mm)": 190,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49,
    "Beak Depth (mm)": 19.6,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 4300,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.5,
    "Beak Depth (mm)": 18.7,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3250,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49.8,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 3675,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 48.1,
    "Beak Depth (mm)": 16.4,
    "Flipper Length (mm)": 199,
    "Body Mass (g)": 3325,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.4,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 201,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.7,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.7,
    "Beak Depth (mm)": 19.7,
    "Flipper Length (mm)": 203,
    "Body Mass (g)": 4050,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 42.5,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 187,
    "Body Mass (g)": 3350,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 52.2,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 197,
    "Body Mass (g)": 3450,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.2,
    "Beak Depth (mm)": 16.6,
    "Flipper Length (mm)": 191,
    "Body Mass (g)": 3250,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49.3,
    "Beak Depth (mm)": 19.9,
    "Flipper Length (mm)": 203,
    "Body Mass (g)": 4050,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.2,
    "Beak Depth (mm)": 18.8,
    "Flipper Length (mm)": 202,
    "Body Mass (g)": 3800,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.6,
    "Beak Depth (mm)": 19.4,
    "Flipper Length (mm)": 194,
    "Body Mass (g)": 3525,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 51.9,
    "Beak Depth (mm)": 19.5,
    "Flipper Length (mm)": 206,
    "Body Mass (g)": 3950,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 46.8,
    "Beak Depth (mm)": 16.5,
    "Flipper Length (mm)": 189,
    "Body Mass (g)": 3650,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 45.7,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 195,
    "Body Mass (g)": 3650,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 55.8,
    "Beak Depth (mm)": 19.8,
    "Flipper Length (mm)": 207,
    "Body Mass (g)": 4000,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 43.5,
    "Beak Depth (mm)": 18.1,
    "Flipper Length (mm)": 202,
    "Body Mass (g)": 3400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 49.6,
    "Beak Depth (mm)": 18.2,
    "Flipper Length (mm)": 193,
    "Body Mass (g)": 3775,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.8,
    "Beak Depth (mm)": 19,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4100,
    "Sex": "MALE"
  },
  {
    "Species": "Chinstrap",
    "Island": "Dream",
    "Beak Length (mm)": 50.2,
    "Beak Depth (mm)": 18.7,
    "Flipper Length (mm)": 198,
    "Body Mass (g)": 3775,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.1,
    "Beak Depth (mm)": 13.2,
    "Flipper Length (mm)": 211,
    "Body Mass (g)": 4500,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50,
    "Beak Depth (mm)": 16.3,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 5700,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.7,
    "Beak Depth (mm)": 14.1,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50,
    "Beak Depth (mm)": 15.2,
    "Flipper Length (mm)": 218,
    "Body Mass (g)": 5700,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.6,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5400,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.5,
    "Beak Depth (mm)": 13.5,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4550,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.4,
    "Beak Depth (mm)": 14.6,
    "Flipper Length (mm)": 211,
    "Body Mass (g)": 4800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.7,
    "Beak Depth (mm)": 15.3,
    "Flipper Length (mm)": 219,
    "Body Mass (g)": 5200,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.3,
    "Beak Depth (mm)": 13.4,
    "Flipper Length (mm)": 209,
    "Body Mass (g)": 4400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.8,
    "Beak Depth (mm)": 15.4,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5150,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 40.9,
    "Beak Depth (mm)": 13.7,
    "Flipper Length (mm)": 214,
    "Body Mass (g)": 4650,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49,
    "Beak Depth (mm)": 16.1,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 5550,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.5,
    "Beak Depth (mm)": 13.7,
    "Flipper Length (mm)": 214,
    "Body Mass (g)": 4650,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.4,
    "Beak Depth (mm)": 14.6,
    "Flipper Length (mm)": 213,
    "Body Mass (g)": 5850,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.8,
    "Beak Depth (mm)": 14.6,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.3,
    "Beak Depth (mm)": 15.7,
    "Flipper Length (mm)": 217,
    "Body Mass (g)": 5850,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 42,
    "Beak Depth (mm)": 13.5,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.2,
    "Beak Depth (mm)": 15.2,
    "Flipper Length (mm)": 221,
    "Body Mass (g)": 6300,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.2,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 209,
    "Body Mass (g)": 4800,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.7,
    "Beak Depth (mm)": 15.1,
    "Flipper Length (mm)": 222,
    "Body Mass (g)": 5350,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.2,
    "Beak Depth (mm)": 14.3,
    "Flipper Length (mm)": 218,
    "Body Mass (g)": 5700,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.1,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5000,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.5,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 213,
    "Body Mass (g)": 4400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.3,
    "Beak Depth (mm)": 15.8,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5050,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 42.9,
    "Beak Depth (mm)": 13.1,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5000,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.1,
    "Beak Depth (mm)": 15.1,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5100,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44.5,
    "Beak Depth (mm)": 14.3,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 4100,
    "Sex": null
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.8,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5650,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.2,
    "Beak Depth (mm)": 14.3,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50,
    "Beak Depth (mm)": 15.3,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 5550,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.3,
    "Beak Depth (mm)": 15.3,
    "Flipper Length (mm)": 222,
    "Body Mass (g)": 5250,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 42.8,
    "Beak Depth (mm)": 14.2,
    "Flipper Length (mm)": 209,
    "Body Mass (g)": 4700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.1,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 207,
    "Body Mass (g)": 5050,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 59.6,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 6050,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.1,
    "Beak Depth (mm)": 14.8,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 5150,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.4,
    "Beak Depth (mm)": 16.3,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 5400,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 42.6,
    "Beak Depth (mm)": 13.7,
    "Flipper Length (mm)": 213,
    "Body Mass (g)": 4950,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44.4,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 219,
    "Body Mass (g)": 5250,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44,
    "Beak Depth (mm)": 13.6,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 4350,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.7,
    "Beak Depth (mm)": 15.7,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 5350,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 42.7,
    "Beak Depth (mm)": 13.7,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 3950,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.6,
    "Beak Depth (mm)": 16,
    "Flipper Length (mm)": 225,
    "Body Mass (g)": 5700,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.3,
    "Beak Depth (mm)": 13.7,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4300,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.6,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 4750,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.5,
    "Beak Depth (mm)": 15.9,
    "Flipper Length (mm)": 222,
    "Body Mass (g)": 5550,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.6,
    "Beak Depth (mm)": 13.9,
    "Flipper Length (mm)": 217,
    "Body Mass (g)": 4900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.5,
    "Beak Depth (mm)": 13.9,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.5,
    "Beak Depth (mm)": 15.9,
    "Flipper Length (mm)": 225,
    "Body Mass (g)": 5400,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44.9,
    "Beak Depth (mm)": 13.3,
    "Flipper Length (mm)": 213,
    "Body Mass (g)": 5100,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.2,
    "Beak Depth (mm)": 15.8,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5300,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.6,
    "Beak Depth (mm)": 14.2,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.5,
    "Beak Depth (mm)": 14.1,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 5300,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.1,
    "Beak Depth (mm)": 14.4,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.1,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 225,
    "Body Mass (g)": 5000,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.5,
    "Beak Depth (mm)": 14.4,
    "Flipper Length (mm)": 217,
    "Body Mass (g)": 4900,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45,
    "Beak Depth (mm)": 15.4,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 5050,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.8,
    "Beak Depth (mm)": 13.9,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 4300,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.5,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 5000,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.2,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 4450,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.4,
    "Beak Depth (mm)": 15.3,
    "Flipper Length (mm)": 224,
    "Body Mass (g)": 5550,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.3,
    "Beak Depth (mm)": 13.8,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 4200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.2,
    "Beak Depth (mm)": 14.9,
    "Flipper Length (mm)": 221,
    "Body Mass (g)": 5300,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.7,
    "Beak Depth (mm)": 13.9,
    "Flipper Length (mm)": 214,
    "Body Mass (g)": 4400,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 54.3,
    "Beak Depth (mm)": 15.7,
    "Flipper Length (mm)": 231,
    "Body Mass (g)": 5650,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.8,
    "Beak Depth (mm)": 14.2,
    "Flipper Length (mm)": 219,
    "Body Mass (g)": 4700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.8,
    "Beak Depth (mm)": 16.8,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 5700,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.2,
    "Beak Depth (mm)": 14.4,
    "Flipper Length (mm)": 214,
    "Body Mass (g)": 4650,
    "Sex": null
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.5,
    "Beak Depth (mm)": 16.2,
    "Flipper Length (mm)": 229,
    "Body Mass (g)": 5800,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.5,
    "Beak Depth (mm)": 14.2,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 4700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.7,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 223,
    "Body Mass (g)": 5550,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.7,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 4750,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.4,
    "Beak Depth (mm)": 15.6,
    "Flipper Length (mm)": 221,
    "Body Mass (g)": 5000,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.2,
    "Beak Depth (mm)": 15.6,
    "Flipper Length (mm)": 221,
    "Body Mass (g)": 5100,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.5,
    "Beak Depth (mm)": 14.8,
    "Flipper Length (mm)": 217,
    "Body Mass (g)": 5200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.4,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 4700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.6,
    "Beak Depth (mm)": 16,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 5800,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.5,
    "Beak Depth (mm)": 14.2,
    "Flipper Length (mm)": 209,
    "Body Mass (g)": 4600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 51.1,
    "Beak Depth (mm)": 16.3,
    "Flipper Length (mm)": 220,
    "Body Mass (g)": 6000,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.2,
    "Beak Depth (mm)": 13.8,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 4750,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.2,
    "Beak Depth (mm)": 16.4,
    "Flipper Length (mm)": 223,
    "Body Mass (g)": 5950,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.1,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 4625,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 52.5,
    "Beak Depth (mm)": 15.6,
    "Flipper Length (mm)": 221,
    "Body Mass (g)": 5450,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.4,
    "Beak Depth (mm)": 14.6,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 4725,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50,
    "Beak Depth (mm)": 15.9,
    "Flipper Length (mm)": 224,
    "Body Mass (g)": 5350,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44.9,
    "Beak Depth (mm)": 13.8,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 4750,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.8,
    "Beak Depth (mm)": 17.3,
    "Flipper Length (mm)": 228,
    "Body Mass (g)": 5600,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.4,
    "Beak Depth (mm)": 14.4,
    "Flipper Length (mm)": 218,
    "Body Mass (g)": 4600,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 51.3,
    "Beak Depth (mm)": 14.2,
    "Flipper Length (mm)": 218,
    "Body Mass (g)": 5300,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.5,
    "Beak Depth (mm)": 14,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 4875,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 52.1,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 5550,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.5,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 218,
    "Body Mass (g)": 4950,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 52.2,
    "Beak Depth (mm)": 17.1,
    "Flipper Length (mm)": 228,
    "Body Mass (g)": 5400,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.5,
    "Beak Depth (mm)": 14.5,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 4750,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.5,
    "Beak Depth (mm)": 16.1,
    "Flipper Length (mm)": 224,
    "Body Mass (g)": 5650,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44.5,
    "Beak Depth (mm)": 14.7,
    "Flipper Length (mm)": 214,
    "Body Mass (g)": 4850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.8,
    "Beak Depth (mm)": 15.7,
    "Flipper Length (mm)": 226,
    "Body Mass (g)": 5200,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.4,
    "Beak Depth (mm)": 15.8,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 4925,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.9,
    "Beak Depth (mm)": 14.6,
    "Flipper Length (mm)": 222,
    "Body Mass (g)": 4875,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.4,
    "Beak Depth (mm)": 14.4,
    "Flipper Length (mm)": 203,
    "Body Mass (g)": 4625,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 51.1,
    "Beak Depth (mm)": 16.5,
    "Flipper Length (mm)": 225,
    "Body Mass (g)": 5250,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.5,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 219,
    "Body Mass (g)": 4850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 55.9,
    "Beak Depth (mm)": 17,
    "Flipper Length (mm)": 228,
    "Body Mass (g)": 5600,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.2,
    "Beak Depth (mm)": 15.5,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 4975,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.1,
    "Beak Depth (mm)": 15,
    "Flipper Length (mm)": 228,
    "Body Mass (g)": 5500,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.3,
    "Beak Depth (mm)": 13.8,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 4725,
    "Sex": null
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.8,
    "Beak Depth (mm)": 16.1,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 5500,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 41.7,
    "Beak Depth (mm)": 14.7,
    "Flipper Length (mm)": 210,
    "Body Mass (g)": 4700,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 53.4,
    "Beak Depth (mm)": 15.8,
    "Flipper Length (mm)": 219,
    "Body Mass (g)": 5500,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.3,
    "Beak Depth (mm)": 14,
    "Flipper Length (mm)": 208,
    "Body Mass (g)": 4575,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.1,
    "Beak Depth (mm)": 15.1,
    "Flipper Length (mm)": 209,
    "Body Mass (g)": 5500,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.5,
    "Beak Depth (mm)": 15.2,
    "Flipper Length (mm)": 216,
    "Body Mass (g)": 5000,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.8,
    "Beak Depth (mm)": 15.9,
    "Flipper Length (mm)": 229,
    "Body Mass (g)": 5950,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 43.5,
    "Beak Depth (mm)": 15.2,
    "Flipper Length (mm)": 213,
    "Body Mass (g)": 4650,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 51.5,
    "Beak Depth (mm)": 16.3,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 5500,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.2,
    "Beak Depth (mm)": 14.1,
    "Flipper Length (mm)": 217,
    "Body Mass (g)": 4375,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 55.1,
    "Beak Depth (mm)": 16,
    "Flipper Length (mm)": 230,
    "Body Mass (g)": 5850,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 44.5,
    "Beak Depth (mm)": 15.7,
    "Flipper Length (mm)": 217,
    "Body Mass (g)": 4875,
    "Sex": "."
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 48.8,
    "Beak Depth (mm)": 16.2,
    "Flipper Length (mm)": 222,
    "Body Mass (g)": 6000,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 47.2,
    "Beak Depth (mm)": 13.7,
    "Flipper Length (mm)": 214,
    "Body Mass (g)": 4925,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": null,
    "Beak Depth (mm)": null,
    "Flipper Length (mm)": null,
    "Body Mass (g)": null,
    "Sex": null
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 46.8,
    "Beak Depth (mm)": 14.3,
    "Flipper Length (mm)": 215,
    "Body Mass (g)": 4850,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 50.4,
    "Beak Depth (mm)": 15.7,
    "Flipper Length (mm)": 222,
    "Body Mass (g)": 5750,
    "Sex": "MALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 45.2,
    "Beak Depth (mm)": 14.8,
    "Flipper Length (mm)": 212,
    "Body Mass (g)": 5200,
    "Sex": "FEMALE"
  },
  {
    "Species": "Gentoo",
    "Island": "Biscoe",
    "Beak Length (mm)": 49.9,
    "Beak Depth (mm)": 16.1,
    "Flipper Length (mm)": 213,
    "Body Mass (g)": 5400,
    "Sex": "MALE"
  }
]"""
}