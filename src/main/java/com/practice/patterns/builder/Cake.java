package com.practice.patterns.builder;

/**
 * Created by shankark on 22/12/16.
 */
class Cake {
        //These two are mandatory
        private final int weight;
        private final String cream;


        private  String dryFruits;
        private  String extras;
        private  String cherry;

        private String milkPowder;

        // If the use doe not need extrs for building Cake object, we should not pass this paramter to Constructor


    @Override
    public String toString() {
        return "Cake{" +
                "weight=" + weight +
                ", cream='" + cream + '\'' +
                ", dryFruits='" + dryFruits + '\'' +
                ", extras='" + extras + '\'' +
                ", cherry='" + cherry + '\'' +
                ", milkPowder='" + milkPowder + '\'' +
                '}';
    }

    private Cake(CakeBuilder builder) {
            this.weight = builder.weight;
            this.cream = builder.cream;
            this.dryFruits = builder.dryFruits;
        }


        public static class CakeBuilder{
            private int weight;
            private String cream;
            private String dryFruits;
            private String extras;
            private String cherry;

            private String milkPowder;



            CakeBuilder(int weight, String cream) {
                this.weight = weight;
                this.cream = cream;
            }

            public CakeBuilder setDryFruits(String dryFruits) {
                this.dryFruits = dryFruits;
                return this;
            }


            Cake build() {
                return new Cake(this);
            }

        }
    }


