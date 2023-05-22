/*    */ package dev.mrauro.cards;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import net.kyori.adventure.text.Component;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class GiveDeck implements CommandExecutor {
/*    */   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
/* 16 */     ItemStack book = new ItemStack(Material.BOOK);
/* 17 */     ItemMeta bookMeta = book.getItemMeta();
/*    */     
/* 19 */     if (bookMeta != null) {
/* 20 */       bookMeta.displayName((Component)Component.text("Cards"));
/*    */       
/* 22 */       ArrayList<String> lore = new ArrayList<>();
/* 23 */       lore.add("AS 2S 3S 4S 5S 6S 7S 8S 9S 10S JS QS KS AD 2D 3D 4D 5D 6D 7D 8D 9D 10D JD QD KD AH 2H 3H 4H 5H 6H 7H 8H 9H 10H JH QH KH AC 2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC KC");
/* 24 */       bookMeta.setLore(lore);
/* 25 */       book.setItemMeta(bookMeta);
/* 26 */       ((Player)sender).getInventory().addItem(new ItemStack[] { book });
/*    */     } 
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\NUC Backup\Minecraft\test\cards-1.0-SNAPSHOT.jar!\dev\mrauro\cards\GiveDeck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */