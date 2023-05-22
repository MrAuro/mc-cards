/*     */ package dev.mrauro.cards;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.kyori.adventure.text.Component;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public final class Cards extends JavaPlugin implements Listener {
/*  16 */   public Map<String, Integer> cards = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  21 */     getServer().getPluginManager().registerEvents(this, (Plugin)this);
/*  22 */     getCommand("givedeck").setExecutor(new GiveDeck());
/*     */     
/*  24 */     this.cards.put("AS", Integer.valueOf(1));
/*  25 */     this.cards.put("2S", Integer.valueOf(2));
/*  26 */     this.cards.put("3S", Integer.valueOf(3));
/*  27 */     this.cards.put("4S", Integer.valueOf(4));
/*  28 */     this.cards.put("5S", Integer.valueOf(5));
/*  29 */     this.cards.put("6S", Integer.valueOf(6));
/*  30 */     this.cards.put("7S", Integer.valueOf(7));
/*  31 */     this.cards.put("8S", Integer.valueOf(8));
/*  32 */     this.cards.put("9S", Integer.valueOf(9));
/*  33 */     this.cards.put("10S", Integer.valueOf(10));
/*  34 */     this.cards.put("JS", Integer.valueOf(11));
/*  35 */     this.cards.put("QS", Integer.valueOf(12));
/*  36 */     this.cards.put("KS", Integer.valueOf(13));
/*  37 */     this.cards.put("AD", Integer.valueOf(14));
/*  38 */     this.cards.put("2D", Integer.valueOf(15));
/*  39 */     this.cards.put("3D", Integer.valueOf(16));
/*  40 */     this.cards.put("4D", Integer.valueOf(17));
/*  41 */     this.cards.put("5D", Integer.valueOf(18));
/*  42 */     this.cards.put("6D", Integer.valueOf(19));
/*  43 */     this.cards.put("7D", Integer.valueOf(20));
/*  44 */     this.cards.put("8D", Integer.valueOf(21));
/*  45 */     this.cards.put("9D", Integer.valueOf(22));
/*  46 */     this.cards.put("10D", Integer.valueOf(23));
/*  47 */     this.cards.put("JD", Integer.valueOf(24));
/*  48 */     this.cards.put("QD", Integer.valueOf(25));
/*  49 */     this.cards.put("KD", Integer.valueOf(26));
/*  50 */     this.cards.put("AH", Integer.valueOf(27));
/*  51 */     this.cards.put("2H", Integer.valueOf(28));
/*  52 */     this.cards.put("3H", Integer.valueOf(29));
/*  53 */     this.cards.put("4H", Integer.valueOf(30));
/*  54 */     this.cards.put("5H", Integer.valueOf(31));
/*  55 */     this.cards.put("6H", Integer.valueOf(32));
/*  56 */     this.cards.put("7H", Integer.valueOf(33));
/*  57 */     this.cards.put("8H", Integer.valueOf(34));
/*  58 */     this.cards.put("9H", Integer.valueOf(35));
/*  59 */     this.cards.put("10H", Integer.valueOf(36));
/*  60 */     this.cards.put("JH", Integer.valueOf(37));
/*  61 */     this.cards.put("QH", Integer.valueOf(38));
/*  62 */     this.cards.put("KH", Integer.valueOf(39));
/*  63 */     this.cards.put("AC", Integer.valueOf(40));
/*  64 */     this.cards.put("2C", Integer.valueOf(41));
/*  65 */     this.cards.put("3C", Integer.valueOf(42));
/*  66 */     this.cards.put("4C", Integer.valueOf(43));
/*  67 */     this.cards.put("5C", Integer.valueOf(44));
/*  68 */     this.cards.put("6C", Integer.valueOf(45));
/*  69 */     this.cards.put("7C", Integer.valueOf(46));
/*  70 */     this.cards.put("8C", Integer.valueOf(47));
/*  71 */     this.cards.put("9C", Integer.valueOf(48));
/*  72 */     this.cards.put("10C", Integer.valueOf(49));
/*  73 */     this.cards.put("JC", Integer.valueOf(50));
/*  74 */     this.cards.put("QC", Integer.valueOf(51));
/*  75 */     this.cards.put("KC", Integer.valueOf(52));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDisable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteractEvent(PlayerInteractEvent event) {
/*  87 */     if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && 
/*  88 */       event.getItem() != null && 
/*  89 */       event.getItem().getType() == Material.BOOK) {
/*     */       
/*  91 */       ItemMeta itemMeta = event.getItem().getItemMeta();
/*  92 */       if (itemMeta != null && 
/*  93 */         itemMeta.hasLore()) {
/*  94 */         List<String> lore = itemMeta.getLore();
/*     */ 
/*     */ 
/*     */         
/*  98 */         String[] loreArray = ((String)lore.get(0)).split(" ");
/*     */         
/* 100 */         if (loreArray.length == 0) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/* 105 */         String card = loreArray[(int)(Math.random() * loreArray.length)];
/*     */         
/* 107 */         Integer cardValue = this.cards.get(card);
/*     */ 
/*     */         
/* 110 */         ItemStack paper = new ItemStack(Material.PAPER);
/* 111 */         ItemMeta paperMeta = paper.getItemMeta();
/* 112 */         if (paperMeta != null) {
/*     */           
/* 114 */           String prettyCard = card.replace("S", "♠").replace("D", "♦").replace("H", "♥").replace("C", "♣");
/* 115 */           paperMeta.setCustomModelData(cardValue);
/* 116 */           paperMeta.displayName((Component)Component.text(prettyCard));
/* 117 */           paper.setItemMeta(paperMeta);
/*     */ 
/*     */           
/* 120 */           if (event.getPlayer().getTargetEntity(10) != null && event.getPlayer().getTargetEntity(10) instanceof Player) {
/* 121 */             Player target = (Player)event.getPlayer().getTargetEntity(10);
/* 122 */             if (target != null) {
/* 123 */               target.getInventory().addItem(new ItemStack[] { paper });
/*     */             }
/*     */           } else {
/*     */             
/* 127 */             event.getPlayer().getInventory().addItem(new ItemStack[] { paper });
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 138 */           List<String> newLore = new ArrayList<>();
/* 139 */           newLore.add(String.join(" ", (CharSequence[])Arrays.<String>stream(loreArray).filter(s -> !s.equals(card)).toArray(x$0 -> new String[x$0])));
/* 140 */           itemMeta.setLore(newLore);
/* 141 */           event.getItem().setItemMeta(itemMeta);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\NUC Backup\Minecraft\test\cards-1.0-SNAPSHOT.jar!\dev\mrauro\cards\Cards.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */