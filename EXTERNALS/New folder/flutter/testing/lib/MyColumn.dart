import 'package:flutter/material.dart';

class Mycolumn extends StatelessWidget {
  const Mycolumn({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Flexible(flex: 2, child: Container(color: Colors.red)),
          Flexible(
            flex: 3,
            child: Container(
              color: const Color.fromARGB(255, 0, 193, 49),
              child: const Text(
                'Lorem ipsum dolor sit amet consectetur adipisicing elit. Non earum, ipsam neque, tenetur id animi fugiat rem dolor delectus illum dolorum vitae veniam. Ipsa sed deserunt maiores quidem at, incidunt ratione natus aspernatur sequi voluptates sit accusantium harum quis, expedita cum iusto nemo magnam ea quia modi deleniti! Voluptas ab at eum dolor quod sequi itaque, laboriosam ipsa molestias aliquid nisi libero provident temporibus modi optio sit? Consequatur, eius qui perferendis fugit, nesciunt quos impedit officia nobis maiores veniam iure nihil soluta dignissimos id molestiae eos sed saepe est. Tempore officia neque iure deserunt aspernatur debitis ut minus beatae excepturi vitae quas eligendi sit facilis ullam cupiditate, laborum, consequatur accusamus commodi rerum dicta earum odit, consectetur natus? Officiis quis, hic quasi suscipit cum vel ut facere labore. Dolores, optio! Cum earum repudiandae cupiditate molestias officia laudantium magnam, hic quod minus voluptate aspernatur culpa id nostrum in aperiam error quidem praesentium, perspiciatis provident saepe. Ab, accusantium quod laboriosam quaerat dolorum quis maxime modi expedita hic sint quo a corrupti voluptas distinctio dolores cumque quidem esse corporis voluptates numquam. Perferendis dolores ea sapiente enim eveniet, quos ipsam cum modi quidem numquam alias, consequatur perspiciatis. Deserunt unde odit tempore nesciunt nisi magni earum ipsam animi ipsa atque necessitatibus inventore, totam minus at, amet, vitae asperiores excepturi quia doloribus? Error expedita quia iste omnis quos sunt sit laboriosam labore voluptatibus esse animi nemo dolores eum repudiandae adipisci distinctio, tenetur, recusandae perferendis incidunt vitae. Aperiam totam, iste neque unde quasi quaerat tenetur, nisi, delectus mollitia voluptas esse in incidunt maiores? Nesciunt placeat distinctio incidunt ipsum fugiat molestias sit, praesentium, recusandae tenetur voluptates voluptate delectus consequatur. Iure, tenetur. Sint perferendis pariatur voluptates ipsum iusto animi error perspiciatis odio natus itaque eum amet recusandae quaerat nulla molestiae dolore, ratione dignissimos excepturi totam mollitia accusamus dolores? Ipsam aliquam aspernatur laboriosam ullam ea inventore tenetur eveniet, consectetur atque, eaque impedit voluptatem est hic reprehenderit provident! Deleniti optio laborum culpa pariatur eos corporis dolorem est eaque porro adipisci magnam, hic sequi ut. Amet quia eveniet aliquam officia reiciendis ullam unde veniam quasi. Doloribus alias accusamus similique. Nulla voluptatem velit libero. Maxime beatae veniam perferendis dolorem dignissimos, voluptatibus porro vel eum ad laboriosam vitae magnam labore blanditiis, in repellat exercitationem minus! Aliquid, facilis at rem necessitatibus, vitae officia unde iure tempore, voluptate provident alias. Neque iusto maxime tenetur animi, vel ipsum esse cum nobis cumque quibusdam veritatis obcaecati harum sunt consequatur.',
              ),
            ),
          ),
          Flexible(
            flex: 3,
            child: Container(color: const Color.fromARGB(255, 0, 76, 255)),
          ),
        ],
      ),
    );
  }
}
